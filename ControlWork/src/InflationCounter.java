import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InflationCounter {

    private static List<Double> inflation = new ArrayList<>();
    private static List<String> countryName = new ArrayList<>();

    public static void addInflation(String country, double infl){
        inflation.add(infl);
        countryName.add(country);
    }

    public static void inflationOut(){
        //Collections.sort(countryName);
        System.out.println("Список стран в лексикографическом порядке с инфляцией:");
        for(int i = 0; i < countryName.size(); i++){
            if(countryName.get(i) != "NULL")
                System.out.println(countryName.get(i) + " - " + inflation.get(i));
        }
    }
}
