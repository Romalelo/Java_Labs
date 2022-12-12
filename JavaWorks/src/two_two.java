import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class two_two {

    public static void main(String[] args) {

        int[] chap;
        String[] chapName;
        int i = 0;
        char chapCh;
        chapName = new String[7];
        chap = new int[7];

        try {
            File myObj = new File("C:\\Users\\User\\IdeaProjects\\JavaWorks\\chapters.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("Chapter")) {
                    chapCh = data.charAt(8);
                    if (data.length() > 9) {
                        chap[i] = (chapCh - '0') * 10;
                        chapCh = data.charAt(9);
                        chap[i] += chapCh - '0';
                    } else
                        chap[i] = chapCh - '0';
                    data = myReader.nextLine();
                    chapName[i] = data;
                    i++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int swapInt;
        String swapString;

        for(i = 0; i < 20; i++)
        {
            boolean swapped = false;

            for(int j = 0; j < 6; j++)
            {
                if(chap[j] > chap[j + 1])
                {
                    swapInt = chap[j];
                    chap[j] = chap[j + 1];
                    chap[j + 1] = swapInt;
                    swapString = chapName[j];
                    chapName[j] = chapName[j + 1];
                    chapName[j + 1] = swapString;
                    swapped = true;
                }
            }

            if(swapped == false)
                break;
        }

        try {
            File myObj = new File("result_2.2.txt");
            if (myObj.createNewFile()) {
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("result_2.2.txt");


            for(i = 0; i < 7; i++){
                myWriter.write("Chapter " + chap[i] + " ----- " + chapName[i] + "\n");
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
