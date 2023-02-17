import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List <String> title = new ArrayList<>(), subject = new ArrayList<>(), director = new ArrayList<>();
    public static List <Integer> year = new ArrayList<>(), length = new ArrayList<>(), popularity = new ArrayList<>();
    public static List <Boolean> awards = new ArrayList<>();

    public static void main(String[] args) {
        Reader.read();
        printFilmInfo();
    }

    public static void addFilm(String titleAdd, String subjectAdd, String directorAdd, Integer yearAdd, Integer lengthAdd, Integer popularityAdd, Boolean awardsAdd){
        title.add(titleAdd);
        year.add(yearAdd);
        length.add(lengthAdd);
        subject.add(subjectAdd);
        director.add(directorAdd);
        popularity.add(popularityAdd);
        awards.add(awardsAdd);
    }

    public static void printFilmInfo(){
        for(int i = 0; i < title.size(); i++) {
            System.out.println(title.get(i) + " " + year.get(i) + " " + length.get(i) + " " + subject.get(i) + " " + director.get(i) + " " + popularity.get(i) + " " + awards.get(i));
        }
    }
}