import java.util.List;
import java.util.Scanner;

public class Main {

    public static int monthInput = 0, yearInput = 0;
    public static List<Integer> monthComfCount = DaysCounter.monthComfCount, monthSubComfCount = DaysCounter.monthSubComfCount, monthUnComfCount = DaysCounter.monthUnComfCount;

    public static void main(String[] args) {
        int max, monthNumber = 0, yearNumber = 2014;

        Reader.read();
        List<Integer> monthComfCount = DaysCounter.monthComfCount;

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
}