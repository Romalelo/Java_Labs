import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static final String COMMA_DELIMITER = ",", DASH_DELIMITER = "-";
    public static double resultOfEET, celsiusTemperature, windSpeedMiles, relativeHumidity, fahrenheitTemperature, windSpeedMS, lineNumber = 0;
    public static List<Integer> day = new ArrayList<>();
    public static List<Integer> month = new ArrayList<>();
    public static List<Integer> year = new ArrayList<>();
    public static List<Integer> monthComfCount = new ArrayList<>();
    public static List<Boolean> IsComf = new ArrayList<>();
    public static List<Double> ET = new ArrayList<>();

    public static void main(String[] args) {
        int max, monthNumber = 0;

        Reader();
        max = monthComfCount.get(0);
        for(int i = 0; i < monthComfCount.size(); i++){
            //System.out.print(monthComfCount.get(i));
            //System.out.print(" ");
            //System.out.println(i);
            if(monthComfCount.get(i) > max){
                max = monthComfCount.get(i);
                monthNumber = i;
            }
            if(i == 12 || i == 23 || i == monthComfCount.size() - 2){
                System.out.println(monthNumber);
                max = 0;
            }
        }
    }

    public static void Reader() {
        List<List<String>> records = new ArrayList<>();
        int counter = 0, monthCounter = 0;
        try (Scanner scanner = new Scanner(new File("data_austin_weather.csv"));) {
            Scanner scannerTwo = new Scanner(new File("data_austin_weather.csv"));
            while (scanner.hasNextLine()) {
                lineNumber++;
                records.add(getRecordFromLine(scanner.nextLine()));
                ET.add(resultOfEET);
                System.out.println(ET.get(ET.size() - 1));
                getDateFromLine(scannerTwo.nextLine());
                if(ET.get(ET.size() - 1) > 12 && ET.get(ET.size() - 1) < 24){
                    IsComf.add(true);
                }
                else{
                    IsComf.add(false);
                }
                if(lineNumber > 1 && month.get(month.size() - 1) == month.get(month.size() - 2)){
                    if(IsComf.get(IsComf.size() - 1)){
                        counter++;
                        monthComfCount.set(monthCounter - 1, counter);
                        System.out.println(monthComfCount.get(monthCounter - 1));
                    }
                }
                else{
                    counter = 0;
                    monthCounter++;
                    monthComfCount.add(0);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        int index = 0;
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            index = 0;
            while (rowScanner.hasNext()) {
                String data = rowScanner.next();
                if (index == 1)
                    try {
                        fahrenheitTemperature = Double.parseDouble(data);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data");
                    }
                else if (index == 2)
                    try {
                        relativeHumidity = Double.parseDouble(data);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data");
                    }
                else if (index == 4)
                    try {
                        windSpeedMiles = Double.parseDouble(data);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data");
                    }
                index++;
                values.add(data);

            }
        }
        //System.out.println(values);

        if(fahrenheitTemperature != -1000 && relativeHumidity != -1000 && windSpeedMiles != -1000) {
            celsiusTemperature = (fahrenheitTemperature - 32) * 1.8;
            windSpeedMS = windSpeedMiles / 2.237;
            resultOfEET = 37 - ((37 - celsiusTemperature) / (0.68 - 0.0014 * relativeHumidity) + (1 / (1.76 + 1.4 * Math.pow(windSpeedMS, 0.75)))) - 0.29 * celsiusTemperature * (1 - (relativeHumidity / 100));

            //System.out.print(resultOfEET);
            //System.out.print(" ");
            //System.out.println(lineNumber);
        }
        fahrenheitTemperature = -1000;
        relativeHumidity = -1000;
        windSpeedMiles = -1000;

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
                        System.out.print(data);
                        System.out.print(" ");
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data");
                    }
                else if (indexD == 1) {
                    try {
                        month.add(Integer.parseInt(data));
                        System.out.print(month.get(month.size() - 1));
                        System.out.print(" ");
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data");
                    }
                }
                else if (indexD == 2) {
                    try {
                        day.add(Integer.parseInt(data) * -1);
                        System.out.println(day.get(day.size() - 1));
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data");
                    }
                }
                indexD++;
                dates.add(data);

            }
        }
        //System.out.println(dates);

        //System.out.print(day);
        //System.out.print(" ");
        //System.out.print(month);
        //System.out.print(" ");
        //System.out.println(year);
        return dates;
    }
}

