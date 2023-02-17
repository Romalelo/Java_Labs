import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    private static final String COMMA_DELIMITER = ",";
    public static int lineNumber = 0;
    public static List <String> countryName = new ArrayList<>();
    public static List <Double> health = new ArrayList<>(), incoming = new ArrayList<>(), infl = new ArrayList<>(), lifetime = new ArrayList<>();

    public static void read() {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("data_country.csv"));) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                records.add(getRecordFromLine(scanner.nextLine()));
                new Country();
                Country.MaxLifetimer();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getRecordFromLine(String line) {

        List<String> values = new ArrayList<String>();

        int index = 0, counter = 0;
        double buff;
        try (Scanner rowScanner = new Scanner(line)) {
            Scanner rowScanner2 = new Scanner(line);
            while(rowScanner2.hasNext()) {
                String data2 = rowScanner2.next();
                char smth[] = data2.toCharArray();
                for (int i = 0; i < smth.length; i++) {
                    if (smth[i] == 44) {
                        counter++;
                    }
                }
            }
            rowScanner.useDelimiter(COMMA_DELIMITER);
            index = 1;
            while (rowScanner.hasNext()) {
                String data = rowScanner.next();
                if(counter != 4){
                    System.out.println("Неверные данные в строке " + lineNumber);
                    countryName.add("NULL");
                    health.add(0.0);
                    incoming.add(0.0);
                    infl.add(0.0);
                    lifetime.add(0.0);
                    break;
                }
                if (index == 1){
                    try{
                        countryName.add(data);
                    } catch (NumberFormatException e){
                        countryName.add("NULL");
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                }
                else if (index == 2)
                    try {
                        buff = Double.parseDouble(data);
                        health.add(buff);
                    } catch (NumberFormatException e) {
                        health.add(0.0);
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                else if (index == 3)
                    try {
                        incoming.add(Double.parseDouble(data));
                    } catch (NumberFormatException e) {
                        incoming.add(0.0);
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                else if (index == 4)
                    try {
                        infl.add(Double.parseDouble(data));
                    } catch (NumberFormatException e) {
                        infl.add(Double.valueOf("\0"));
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                else if (index == 5)
                    try {
                        lifetime.add(Double.parseDouble(data));
                    } catch (NumberFormatException e) {
                        lifetime.add(Double.valueOf("\0"));
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                index++;
                values.add(data);
            }
        }
        return values;
    }
}
