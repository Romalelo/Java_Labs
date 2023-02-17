import java.util.ArrayList;
import java.util.List;

public class MaxLifetime {

    public static double maxLifetime = 0;
    public static List<String> maxLifetimeCountry = new ArrayList<>();
    private static List<String> countryName = new ArrayList<>();
    private static List<Double> lifetime = new ArrayList<>();
    private static int index = 0;

    public static void addLifetime(String country, double life){
        countryName.add(country);
        lifetime.add(life);
    }
    public static void lifetimeCounter(){
        if(Reader.lineNumber > 1 && maxLifetime <= lifetime.get(lifetime.size() - 1)){
            maxLifetime = lifetime.get(lifetime.size() - 1);
            maxLifetimeCountry.add(countryName.get(countryName.size() - 1));
        }
        if(Reader.lineNumber == 1){
            maxLifetime = lifetime.get(lifetime.size() - 1);
            maxLifetimeCountry.add(countryName.get(countryName.size() - 1));
        }
    }

    private static void lifetimeEn(){
        maxLifetimeCountry.clear();
        for(int i = 0; i < lifetime.size(); i++) {
            if (lifetime.get(i) == maxLifetime) {
                maxLifetimeCountry.add(countryName.get(i));
            }
        }
    }

    public static void lifetimeOutput(){
        lifetimeEn();
        System.out.println("Список стран с наибольшим значением показателя продолжительности жизни:");
        for(int i = 0; i < maxLifetimeCountry.size(); i++){
            System.out.println(maxLifetimeCountry.get(i));
        }
    }
}
