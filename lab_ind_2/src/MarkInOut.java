import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class MarkInOut {

    public static void readLine() {
        try (Scanner scanner = new Scanner(new File("data_stud_mark.txt"));) {
            List<List<String>> records = new ArrayList<>();
            int identifier = 0, index = 11;
            boolean isRowsOkay = false;
            String gender = " ";
            String group = " ";
            String education = " ";
            String state = " ";
            String completed = " ";
            Integer firstSubject = 0;
            Integer secondSubject = 0;
            Integer thirdSubject = 0;
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (index == 11) {
                    identifier++;
                    isRowsOkay = false;
                    int buff = 0;
                    try {
                        buff = Integer.parseInt(data);
                    } catch (NumberFormatException e) {
                        System.out.println("Smth went wrong.");
                        System.exit(0);
                    }
                    if (identifier == buff) {
                        new Mark(gender, group, education, state, completed, firstSubject, secondSubject, thirdSubject);
                        isRowsOkay = true;
                        index -= 10;
                    }
                    if (index == 11) {
                        System.out.println("Smth went wrong.");
                        System.exit(0);
                    }
                }
                if (isRowsOkay) {
                    if (index == 2) {
                        try {
                            gender = data;
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            gender = "N/A";
                        }
                    }
                    if (index == 3) {
                        try {
                            group = (data);
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            group = "N/A";
                        }
                    }
                    if (index == 4) {
                        try {
                            education = data;
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            education = "N/A";
                        }
                    }
                    if (index == 5) {
                        try {
                            state = data;
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            state = "N/A";
                        }
                    }
                    if (index == 6) {
                        try {
                            completed = data;
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            completed = "N/A";
                        }
                    }
                    if (index == 7) {
                        try {
                            firstSubject = Integer.parseInt(data);
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            firstSubject = 0;
                        }
                    }
                    if (index == 8) {
                        try {
                            secondSubject = Integer.parseInt(data);
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            secondSubject = 0;
                        }
                    }
                    if (index == 9) {
                        try {
                            thirdSubject = Integer.parseInt(data);
                        } catch (NumberFormatException e) {
                            System.out.println("Smth went wrong.");
                            thirdSubject = 0;
                        }
                    }
                }
                index++;

            }
        } catch (FileNotFoundException e) {
            System.out.println("Smth went wrong.");
        }
    }

    public static Mark readMark(Scanner in) throws Exception {
        if (!in.hasNext()) {
            throw new Exception("Wrong file format");
        }
        String gender = in.nextLine();
        if (!in.hasNext()) {
            throw new Exception("Wrong file format");
        }
        String group = in.nextLine();
        if (!in.hasNext()) {
            throw new Exception("Wrong file format");
        }
        String education = in.nextLine();
        if (!in.hasNext()) {
            throw new Exception("Wrong file format");
        }
        String state = in.nextLine();
        if (!in.hasNext()) {
            throw new Exception("Wrong file format");
        }
        String completed = in.nextLine();
        if (!in.hasNextInt()) {
            throw new Exception("Wrong file format");
        }
        Integer firstSubject = Integer.parseInt(in.nextLine());
        if (!in.hasNextInt()) {
            throw new Exception("Wrong file format");
        }
        Integer secondSubject = Integer.parseInt(in.nextLine());
        if (!in.hasNextInt()) {
            throw new Exception("Wrong file format");
        }
        Integer thirdSubject = Integer.parseInt(in.nextLine());
        return new Mark(
                gender,
                group,
                education,
                state,
                completed,
                firstSubject,
                secondSubject,
                thirdSubject
        );
    }

    public static LinkedList<Mark> readMarks(String filename) {
        int lineNumbers = 0;
        File file = new File(filename);
        LinkedList<Mark> marks = new LinkedList<>();
        try {
            Scanner in = new Scanner(file);
            try {
                while (true) {
                    marks.add(readMark(in));
                    lineNumbers++;
                }
            } catch (Exception e) {
                System.out.println("File read");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        /*if (lineNumbers * 8 != 6072) {
            System.out.println("Wrong input file");
            System.exit(0);
        }*/
        return marks;
    }

    public static MarkSubject getSubject() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter subject (FIRST_SUBJECT,SECOND_SUBJECT,THIRD_SUBJECT are allowed):");
            String temp = in.next();
            try {
                return MarkSubject.valueOf(temp);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public static Gender getGender() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter gender (female,male are allowed):");
            String temp = in.next();
            try {
                return Gender.valueOf(temp);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public static String getEducation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter education:");
        return in.nextLine();
    }
}
