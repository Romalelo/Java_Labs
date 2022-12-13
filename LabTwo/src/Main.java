import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readInputFile();
        Country.writeInfoAboutAllCountries();

        Sport.writeListOfSportsToFile();
        Country.writeListOfOlympicGames(inputCodeOfCountry());

        Country.printListOfCountriesFirstSort();
        Country.printListOfCountriesSecondSort();
        Country.printListOfCountriesThirdSort();
    }

    public static String inputCodeOfCountry() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите код страны для просмотра списка ОИ, в которых она не участвовала.\nФормат кода страны: 3 заглавные английские буквы: ");
        String line = in.nextLine();
        if (!line.matches("[A-Z][A-Z][A-Z]")) {
            System.out.println("Вами был неверно указан код страны. Формат кода страны: 3 заглавные английские буквы");
            System.out.println("Повторите попытку ввода");
            return inputCodeOfCountry();
        }
        else return line;
    }

    public static void readInputFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/data_olimpic_summer.csv"));
            for (;;) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                else {
                    new Olympian(line);
                }
            }
        }
        catch (IOException ex) {
            System.out.println("Входной файл не найден");
        }
    }

    public static void fileWriter(String str) {
        try {
            FileWriter file = new FileWriter("src/output1.txt");
            file.write(str + "\n");
            file.close();
        } catch (IOException ex) {
            System.out.println("Входной файл не найден");
        }
    }
}