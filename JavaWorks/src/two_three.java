import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class two_three {

    public static void main(String[] args) {

        List<Integer> counterList = new ArrayList<Integer>();
        List<Integer> indexes = new ArrayList<Integer>();
        List<String> lines = new ArrayList<String>();
        int counter = 0, lineCounter = 0;

        try {
            File myObj = new File("C:\\Users\\User\\IdeaProjects\\JavaWorks\\input_2.3.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
                for (int i = 0; i < data.length(); i++) {
                    if (data.charAt(i) == 'а') {
                        counter++;
                    }
                }
                counterList.add(counter);
                indexes.add(lineCounter);
                lineCounter++;
                counter = 0;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("result_2.3.txt");
            if (myObj.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int swapInt, swapIndex;

        for (int i = 0; i < 20; i++) {

            for (int j = 0; j < counterList.size() - 1; j++) {
                if (counterList.get(j) > counterList.get(j + 1)) {
                    swapInt = counterList.get(j);
                    counterList.set(j, counterList.get(j + 1));
                    counterList.set(j + 1, swapInt);
                    swapIndex = indexes.get(j);
                    indexes.set(j, indexes.get(j + 1));
                    indexes.set(j + 1, swapIndex);
                }
            }
        }

        try {
            FileWriter myWriter = new FileWriter("result_2.3.txt");
            for(int i = counterList.size() - 1; i >= 0; i--){
                myWriter.write(lines.get(indexes.get(i)) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}