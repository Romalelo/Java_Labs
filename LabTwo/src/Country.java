import java.util.*;

public class Country {
    static ArrayList<Country> listOfCountries = new ArrayList<>();
    static HashSet<String> fullListOfOlympicGames = new HashSet<>();

    private ArrayList<Olympian> listOfOlympianOfThisCountry = new ArrayList<>();
    private HashSet<String> OlympicGamesOfThisCountry = new HashSet<>();
    private String codeOfCountry;

    public Country(String codeOfCountry) {
        this.codeOfCountry = codeOfCountry;
    }

    public void printInfoToFile() {
        HashMap<String, HashSet<Olympian>> medals = medals();
        printInfoAboutMedalists("Золотые", medals.get("Gold"));
        printInfoAboutMedalists("Серебряные", medals.get("Silver"));
        printInfoAboutMedalists("Бронзовые", medals.get("Bronze"));
        printCountChampions(medals.get("Gold"));
    }

    public void printInfoAboutMedalists(String medal, HashSet<Olympian> medalists) {
        Main.fileWriter("\n" + medal + " медалисты страны " + this.codeOfCountry + ":");
        for (Olympian olympian : medalists) {
            Main.fileWriter(olympian.getInfoToPrint());
        }
    }

    public void printCountChampions(HashSet<Olympian> champions) {
        int countMen = 0;
        int countWomen = 0;
        for (Olympian champion : champions) {
            if (champion.getGender().equals("Men")) countMen++;
            else countWomen++;
        }
        Main.fileWriter("\nКоличество мужчин-чемпионов: " + countMen + "\nКоличество женщин-чемпионов: " + countWomen);
    }

   private HashMap<String, HashSet<Olympian>> medals() {
        HashMap<String, HashSet<Olympian>> medals = new HashMap<>(Map.of("Gold", new HashSet<>(), "Silver", new HashSet<>(), "Bronze", new HashSet<>()));
        for (Olympian olympian : listOfOlympianOfThisCountry) {
            medals.get(olympian.getMedal()).add(olympian);
        }
        return medals;
    }

    public void addOlympian(Olympian olympian, String olympicGames) {

        listOfOlympianOfThisCountry.add(olympian);
        OlympicGamesOfThisCountry.add(olympicGames);
    }

    public static boolean isCreatedBefore(String codeOfCountry) {
        for (Country country : listOfCountries) {
            if (country.getCodeOfCountry().equals(codeOfCountry)) return true;
        }
        return false;
    }

    public static Country getCountry(String codeOfCountry) {
        for (Country country : listOfCountries) {
            if (country.getCodeOfCountry().equals(codeOfCountry)) return country;
        }
        return null;
    }

    public String getCodeOfCountry() {
        return codeOfCountry;
    }

    public ArrayList<Olympian> getListOfOlympystOfThisCountry() {
        return listOfOlympianOfThisCountry;
    }

    public static void writeListOfOlympicGames(String codeOfCountry) {
        Country country = Country.getCountry(codeOfCountry);
        if (country == null) {
            Main.fileWriter("Список олимпийских игр, в которых не участвовала заданная вами страна,");
            Main.fileWriter("составить невозможно, т.к. страны с заданным вами кодом (" + codeOfCountry + ") не существует");
            System.out.println("Информация успешно выведена в файл");
        } else {
            Main.fileWriter("Олимпийские игры, в которых не участвовала страна " + codeOfCountry + ":");
            TreeSet<String> toPrint = new TreeSet<>((s1, s2) -> s1.compareTo(s2));
            toPrint.addAll(Country.fullListOfOlympicGames);
            toPrint.removeAll(country.OlympicGamesOfThisCountry);
            writeTreeSet(toPrint);
            System.out.println("Список " + toPrint.size() + " олимпиад, в которых не участвовала заданная страна, успешно выведен в файл");
        }
    }

    private static void writeTreeSet(TreeSet<String> toPrint) {
        if (!toPrint.isEmpty()) {
            for (String s : toPrint) {
                Main.fileWriter(s);
            }
        }
    }

    public static void writeInfoAboutAllCountries() {
        for (Country country : Country.listOfCountries) {
            country.printInfoToFile();
        }
    }

    static Scanner in = new Scanner(System.in);

    public static ArrayList<Integer> getFullListOfYearsOfOlympicGames() {
        ArrayList<Integer> returnedList = new ArrayList<>();
        for (String olympicGame : fullListOfOlympicGames) {
            returnedList.add(Integer.parseInt(olympicGame.split(" +")[0]));
        }
        return returnedList;
    }

    public static int inputYear() {
        System.out.print("\nВведите год, по количеству медалей в котором хотите упорядочить страны: ");
        try {
            String strYear = in.nextLine();
            if (!strYear.matches("(189[6-9])|(19[0-9][0-9])|(20(([01][0-9])|(2[0-2])))")) throw new NumberFormatException("Год должен быть числом от 1896 до 2022");

            int year = Integer.parseInt(strYear);
            if (!getFullListOfYearsOfOlympicGames().contains(year)) throw new NumberFormatException("В этом году олимпиады не было");

            System.out.println("Год успешно введен!");
            return year;
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getMessage() + ". Повторите ввод");
            return inputYear();
        }
    }

    public static ArrayList<String> inputMedals() {
        System.out.println("\n(C)Медали задаются либо полным словом (Gold, Silver, Bronze), либо, если надо все сразу, - \"all\"");
        System.out.print("Введите медали, по количеству которых вы ходите упорядочить страны: ");

        String line = in.nextLine();
        if (!line.matches("(all)|(Gold)|(Silver)|(Bronze)")) {
            System.out.println("Ошибка: Ввод медалей не соответствует формату");
            return inputMedals();
        }

        ArrayList<String> returned = new ArrayList<>();
        if (!line.equals("all")) returned.add(line);
        else returned.addAll(List.of("Gold", "Silver", "Bronze"));

        return returned;
    }

    private int getCountOfSelectedMedals(ArrayList<String> medals, int year) {
        int count = 0;
        for (Olympian olympian: listOfOlympianOfThisCountry) {
            if (medals.contains(olympian.getMedal()) && year == olympian.getYear()) count++;
        }
        return count;
    }

    private static void printListOfCountries(String comparatorMessage) {
        System.out.println("\nСписок стран, отсортированный по " + comparatorMessage + ":");
        for (Country country: listOfCountries) {
            System.out.println(country.getCodeOfCountry() + " ");
        }
    }

    public static void printListOfCountriesFirstSort() {
        int year = inputYear();
        ArrayList<String> medals = inputMedals();
        listOfCountries.sort((c1, c2) -> Integer.compare(c2.getCountOfSelectedMedals(medals, year), c1.getCountOfSelectedMedals(medals, year)));
        printListOfCountries("убыванию количества заданных медалей");
    }

    private float getPercentWomenChampions() {
        float cntWomansChampions = 0;
        float cntChampions = 0;
        for (Olympian olympian : listOfOlympianOfThisCountry) {
            if (olympian.getMedal().equals("Gold")) {
                cntChampions += 1;
                if (olympian.getGender().equals("Women")) {
                    cntWomansChampions += 1;
                }
            }
        }
        if (cntChampions != 0) return (cntWomansChampions / cntChampions);
        else return -1;
    }

    public static void printListOfCountriesSecondSort() {
        listOfCountries.sort((c1, c2) -> Float.compare(c2.getPercentWomenChampions(), c1.getPercentWomenChampions()));
        printListOfCountries("убыванию процента женщин-чемпионов");
    }

    private int getCountMultichampions() {
        int count = 0;
        HashSet<String>namesOfChampions = new HashSet<>();
        for (Olympian olympian: listOfOlympianOfThisCountry) {
            if (namesOfChampions.contains(olympian.getName())) count++;
            else {
                if (olympian.getMedal().equals("Gold")) namesOfChampions.add(olympian.getName());
            }
        }
        return count;
    }

    public static void printListOfCountriesThirdSort() {
        listOfCountries.sort((c1, c2) -> Integer.compare(c1.getCountMultichampions(), c2.getCountMultichampions()));
        printListOfCountries("возрастанию числа многократных чемпионов");
    }
}