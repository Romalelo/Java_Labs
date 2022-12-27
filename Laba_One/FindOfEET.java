import java.util.ArrayList;
import java.util.List;

public class FindOfEET {

    public static List<Double> ET = new ArrayList<>();
    public static List<Double> fahrenheitTemperature = Reader.fahrenheitTemperature, relativeHumidity = Reader.relativeHumidity, windSpeedMiles = Reader.windSpeedMiles;
    public static double celsiusTemperature, windSpeedMS, resultOfEET = 0;

    public static void ETCounter(){
        for(int i = 0; i < fahrenheitTemperature.size(); i++) {
            if (fahrenheitTemperature.get(i) != -1000 && relativeHumidity.get(i) != -1000 && windSpeedMiles.get(i) != -1000) {
                celsiusTemperature = (fahrenheitTemperature.get(i) - 32) * 5 / 9;
                windSpeedMS = windSpeedMiles.get(i) * 0.44704;
                resultOfEET = 37 - (37 - celsiusTemperature) / (0.68 - 0.0014 * relativeHumidity.get(i) + 1 / (1.76 + 1.4 * Math.pow(windSpeedMS, 0.75))) - 0.29 * celsiusTemperature * (1 - relativeHumidity.get(i) / 100);
            }
            ET.add(resultOfEET);
        }
    }
}
