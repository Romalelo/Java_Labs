import java.util.ArrayList;
import java.util.List;

public class DaysCounter {

    public static List<Double> ET = FindOfEET.ET;
    public static List<Integer> monthComfCount = new ArrayList<>(), monthSubComfCount = new ArrayList<>(), monthUnComfCount = new ArrayList<>();
    public static List<Boolean> IsComf = new ArrayList<>(), IsSubComf = new ArrayList<>(), IsUnComf = new ArrayList<>();

    public static void counter(){
        int comfCounter = 0, monthCounter = 0, subComfCounter = 0, unComfCounter = 0;
        if(monthComfCount.size()==0){
            monthComfCount.add(0);
        }
        if(monthSubComfCount.size()==0){
            monthSubComfCount.add(0);
        }
        if(monthUnComfCount.size()==0){
            monthUnComfCount.add(0);
        }

        FindOfEET.ETCounter();

        for(int i = 0; i < ET.size(); i++){
            if(ET.get(i) > 12 && ET.get(i) < 24){
                IsComf.add(true);
            }
            else{
                IsComf.add(false);
            }
            if((ET.get(i) > 24 && ET.get(i) <= 30) || (i >= 6 && ET.get(i) <= 12)){
                IsSubComf.add(true);
            }
            else{
                IsSubComf.add(false);
            }
            if(ET.get(i) > 30 || ET.get(i) < 6){
                IsUnComf.add(true);
            }
            else{
                IsUnComf.add(false);
            }
            if(Reader.lineNumber == 1){
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
            if(Reader.lineNumber > 1 && Reader.month.get(Reader.month.size() - 1) == Reader.month.get(Reader.month.size() - 2)){
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
    }
}
