import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static int monthInput = 0, yearInput = 0;
    public static List<Integer> monthComfCount = DaysCounter.monthComfCount, monthSubComfCount = DaysCounter.monthSubComfCount, monthUnComfCount = DaysCounter.monthUnComfCount;
    public static List<Boolean> IsComf = DaysCounter.IsComf, IsSubComf = DaysCounter.IsSubComf, IsUnComf = DaysCounter.IsUnComf;
    public static List<Double> ET = new ArrayList<>();

    public static void main(String[] args) {
        int max, monthNumber = 0, yearNumber = 2014;
        Scanner in = new Scanner(System.in);


        Reader.read();
        DaysCounter.counter();
        List<Integer> monthComfCount = DaysCounter.monthComfCount, monthSubComfCount = DaysCounter.monthSubComfCount, monthUnComfCount = DaysCounter.monthUnComfCount;

        max = monthComfCount.get(0);
        for(int i = 0; i < monthComfCount.size(); i++){
            if(monthComfCount.get(i) > max){
                max = monthComfCount.get(i);
                monthNumber = i;
            }
            if(i == 12 || i == 23 || i == monthComfCount.size() - 2){
                System.out.print("Самый комфортный месяц в " + yearNumber + " году: ");
                yearNumber++;
                if(monthNumber > 11)
                    monthNumber -= 12;
                if(monthNumber > 11)
                    monthNumber -= 12;
                System.out.println(monthNumber + 1);
                max = 0;
            }
        }

        Days();

        }

    public static void Days() {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Введите месяц: ");
            try {
                monthInput = in.nextInt();
                if (monthInput < 1 || monthInput > 12) {
                    System.out.println("Введен неверный месяц\n");
                    Days();
                }
            } catch (Exception e) {
                break;
            }
            System.out.print("Введите год: ");
            try {
                yearInput = in.nextInt();
                if(yearInput < 2014 || yearInput > 2016){
                    System.out.println("Введен неверный год\n");
                    Days();
                }
            } catch (Exception e) {
                break;
            }
            int number = 0;
            number = ((2014 - yearInput) * -1) * 12 + monthInput - 1;
            System.out.println("Количество комфортных дней в " + monthInput + "-" + yearInput + ": " + monthComfCount.get(number));
            System.out.println("Количество субкомфортных дней в " + monthInput + "-" + yearInput + ": " + monthSubComfCount.get(number));
            System.out.println("Количество дискомфортных дней в " + monthInput + "-" + yearInput + ": " + monthUnComfCount.get(number));
        }
    }

    /*public static void Reader() {
        List<List<String>> records = new ArrayList<>();
        int comfCounter = 0, monthCounter = 0, subComfCounter = 0, unComfCounter = 0;
        monthComfCount.add(0);
        monthSubComfCount.add(0);
        monthUnComfCount.add(0);
        try (Scanner scanner = new Scanner(new File("data_austin_weather.csv"));) {
            Scanner scannerTwo = new Scanner(new File("data_austin_weather.csv"));
            while (scanner.hasNextLine()) {
                lineNumber++;
                records.add(getRecordFromLine(scanner.nextLine()));
                ET.add(resultOfEET);
                getDateFromLine(scannerTwo.nextLine());
                if(ET.get(ET.size() - 1) > 12 && ET.get(ET.size() - 1) < 24){
                    IsComf.add(true);
                }
                else{
                    IsComf.add(false);
                }
                if((ET.get(ET.size() - 1) > 24 && ET.get(ET.size() - 1) <= 30) || (ET.get(ET.size() - 1) >= 6 && ET.get(ET.size() - 1) <= 12)){
                    IsSubComf.add(true);
                }
                else{
                    IsSubComf.add(false);
                }
                if(ET.get(ET.size() - 1) > 30 || ET.get(ET.size() - 1) < 6){
                    IsUnComf.add(true);
                }
                else{
                    IsUnComf.add(false);
                }
                if(lineNumber == 1){
                    if(IsComf.get(IsComf.size() - 1)){
                        comfCounter++;
                        monthComfCount.set(monthCounter, comfCounter);
                    }
                    if(IsSubComf.get(IsComf.size() - 1)){
                        subComfCounter++;
                        monthSubComfCount.set(monthCounter, subComfCounter);
                    }
                    if(IsUnComf.get(IsUnComf.size() - 1)){
                        unComfCounter++;
                        monthUnComfCount.set(monthCounter, unComfCounter);
                    }
                }
                if(lineNumber > 1 && month.get(month.size() - 1) == month.get(month.size() - 2)){
                    if(IsComf.get(IsComf.size() - 1)){
                        comfCounter++;
                        monthComfCount.set(monthCounter - 1, comfCounter);
                    }
                    if(IsSubComf.get(IsComf.size() - 1)){
                        subComfCounter++;
                        monthSubComfCount.set(monthCounter - 1, subComfCounter);
                    }
                    if(IsUnComf.get(IsUnComf.size() - 1)){
                        unComfCounter++;
                        monthUnComfCount.set(monthCounter - 1, unComfCounter);
                    }
                }
                else{
                    comfCounter = 0;
                    subComfCounter = 0;
                    unComfCounter = 0;
                    monthCounter++;
                    monthComfCount.add(0);
                    monthSubComfCount.add(0);
                    monthUnComfCount.add(0);
                    if(IsComf.get(IsComf.size() - 1)){
                        comfCounter++;
                        monthComfCount.set(monthCounter - 1, comfCounter);
                    }
                    if(IsSubComf.get(IsComf.size() - 1)){
                        subComfCounter++;
                        monthSubComfCount.set(monthCounter - 1, subComfCounter);
                    }
                    if(IsUnComf.get(IsUnComf.size() - 1)){
                        unComfCounter++;
                        monthUnComfCount.set(monthCounter - 1, unComfCounter);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

    /*private static List<String> getRecordFromLine(String line) {
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
                        System.out.println("Incorrect data in " + lineNumber + " line");
                    }
                else if (index == 2)
                    try {
                        relativeHumidity = Double.parseDouble(data);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data in " + lineNumber + " line");
                    }
                else if (index == 4)
                    try {
                        windSpeedMiles = Double.parseDouble(data);
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect data in " + lineNumber + " line");
                    }
                index++;
                values.add(data);

            }
        }
        if(fahrenheitTemperature != -1000 && relativeHumidity != -1000 && windSpeedMiles != -1000) {
            celsiusTemperature = (fahrenheitTemperature - 32) * 5 / 9;
            windSpeedMS = windSpeedMiles * 0.44704;
            resultOfEET = 37 - (37 - celsiusTemperature) / (0.68 - 0.0014 * relativeHumidity + 1 / (1.76 + 1.4 * Math.pow(windSpeedMS, 0.75))) - 0.29 * celsiusTemperature * (1 - relativeHumidity/100);
        }
        fahrenheitTemperature = -1000;
        relativeHumidity = -1000;
        windSpeedMiles = -1000;

        return values;
    }*/

    /*private static List<String> getDateFromLine(String line) {
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
    }*/
}