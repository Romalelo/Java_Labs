import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static final String COMMA_DELIMITER = ",", DASH_DELIMITER = "-";
    public static List<Integer> day = new ArrayList<>(), month = new ArrayList<>(), year = new ArrayList<>();
    public static int lineNumber = 0;
    public static List<Double> windSpeedMiles = new ArrayList<>(), relativeHumidity = new ArrayList<>(), fahrenheitTemperature = new ArrayList<>();

    public static void read() {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("data_austin_weather.csv"));) {
            Scanner scannerTwo = new Scanner(new File("data_austin_weather.csv"));
            while (scanner.hasNextLine()) {
                lineNumber++;
                records.add(getRecordFromLine(scanner.nextLine()));
                getDateFromLine(scannerTwo.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getRecordFromLine(String line) {

        List<String> values = new ArrayList<String>();

        int index = 0;
        double buff;
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            index = 0;
            while (rowScanner.hasNext()) {
                String data = rowScanner.next();
                if (index == 1)
                    try {
                        buff = Double.parseDouble(data);
                        fahrenheitTemperature.add(buff);
                    } catch (NumberFormatException e) {
                        fahrenheitTemperature.add(Double.valueOf(-1000));
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                else if (index == 2)
                    try {
                        relativeHumidity.add(Double.parseDouble(data));
                    } catch (NumberFormatException e) {
                        relativeHumidity.add(Double.valueOf(-1000));
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                else if (index == 4)
                    try {
                        windSpeedMiles.add(Double.parseDouble(data));
                    } catch (NumberFormatException e) {
                        windSpeedMiles.add(Double.valueOf(-1000));
                        System.out.println("Неверные данные в строке " + lineNumber);
                    }
                index++;
                values.add(data);

            }
        }

        return values;
    }

    private static List<String> getDateFromLine(String line) {
        List<String> dates = new ArrayList<String>();
        int indexD = 0;
        try (Scanner rowScanner = new Scanner(line)) {
            indexD = 0;
            while (rowScanner.hasNext()) {
                rowScanner.useDelimiter(DASH_DELIMITER);
                if(indexD > 1) {
                    rowScanner.useDelimiter(COMMA_DELIMITER);
                }
                String data = rowScanner.next();
                if (indexD == 0)
                    try {
                        year.add(Integer.parseInt(data));
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data in " + lineNumber + " line");
                    }
                else if (indexD == 1) {
                    try {
                        month.add(Integer.parseInt(data));
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data in " + lineNumber + " line");
                    }
                }
                else if (indexD == 2) {
                    try {
                        day.add(Integer.parseInt(data) * -1);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data in " + lineNumber + " line");
                    }
                }
                indexD++;
                dates.add(data);

            }
        }
        return dates;
    }
}
