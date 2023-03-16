import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    LinkedList<Mark> marks = MarkInOut.readMarks("C:\\Users\\User\\IdeaProjects\\lab_ind_2\\data_stud_mark.txt");
	    Parts.part1(marks);
	    Parts.part2(marks);
	    Parts.part3(marks);
    }
}
