import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static double first, second;
    private static List<Double> incoming = new ArrayList<>();
    private static List<String> countryName = new ArrayList<>();

    public static void main(String[] args){
        Reader.read();
        MaxLifetime.lifetimeOutput();
        System.out.println("");
        InflationCounter.inflationOut();
        inputter();
    }

    public static void inputter(){
        Scanner in = new Scanner(System.in);

        System.out.println("Введите начальное число диапазона:");
        try{
            first = in.nextDouble();
        } catch(Exception e){
            System.out.println("Неверный ввод!");
        }

        System.out.println("Введите конечное число диапазона:");
        try{
            second = in.nextDouble();
        } catch(Exception e){
            System.out.println("Неверный ввод!");
        }
        diaIncome();


    }

    public static void addIncome(String country, double income){
        incoming.add(income);
        countryName.add(country);
    }

    public static void diaIncome(){
        System.out.println("Список стран с доходом в диапазоне:");
        for(int i = 0; i < incoming.size(); i++){
            if(incoming.get(i) > first && incoming.get(i) < second){
                System.out.println(countryName.get(i));
            }
        }
    }
}
