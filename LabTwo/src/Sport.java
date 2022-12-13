import java.util.HashSet;

public class Sport {

    static HashSet<String> setOfAllSports = new HashSet<>();
    private static int getCountOfSportsmen(Country country, String sport) {
        int count = 0;
        for (Olympian olympian: country.getListOfOlympystOfThisCountry()) {
            if ((olympian.getSport().equals(sport)) && olympian.getMedal().equals("Gold")) count++;
        }
        return count;
    }

    private static Country getCountryWithTheMaxCountOfSportsmen(String sport) {
        return Country.listOfCountries.stream().max((c1, c2) -> Integer.compare(getCountOfSportsmen(c1, sport), getCountOfSportsmen(c2, sport))).get();
    }

    public static void writeListOfSportsToFile() {
        Main.fileWriter("Дополнительное: Список видов спорта с указанием страны с наибольшим количеством чемпионов в этом виде спорта:");
        for (String sport: setOfAllSports) {
            Main.fileWriter(sport + ": " + getCountryWithTheMaxCountOfSportsmen(sport).getCodeOfCountry());
        }
    }
}
