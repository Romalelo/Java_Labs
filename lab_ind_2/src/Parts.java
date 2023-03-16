import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Parts {
    public static HashSet<String> getGroups(LinkedList<Mark> marks){
        HashSet<String> groups = marks.stream().map(Mark::getGroup).collect(Collectors.toCollection(HashSet::new));
        return groups;
    }
    public static HashSet<String> getEducations(LinkedList<Mark> marks){
        HashSet<String> educations = marks.stream().map(Mark::getEducation).collect(Collectors.toCollection(HashSet::new));
        return educations;
    }
    public static long countByGroupEducation(LinkedList<Mark> marks, String group, String education){
        return marks.stream().filter(el->el.getGroup().equals(group) && el.getEducation().equals(education)).count();
    }
    public static Double calculateAverageByGroupEducation(LinkedList<Mark> marks, String group, String education){
        long count = countByGroupEducation(marks, group, education);
        Double scoreSum = marks.stream().filter(el->el.getGroup().equals(group) && el.getEducation().equals(education)).map(el->el.calculateAverage()*3).reduce(0d,(out,a)->out+a, (a,b)->a+b);
        return scoreSum/count;
    }
    public static long countBySubjectGender(LinkedList<Mark> marks, String gender, MarkSubject markSubject){
        long count = marks.stream().filter(el->el.getGender().equals(gender)).count();
        return count;
    }
    public static long getMaxBySubjectGender(LinkedList<Mark> marks, String gender, MarkSubject markSubject){
        Integer max = -1;
        switch (markSubject) {
            case FIRST_SUBJECT:
                max = marks.stream().filter(el->el.getGender().equals(gender)).map(Mark::getFirstSubject).max((a, b)->a.compareTo(b)).orElse(-1);
                break;
            case SECOND_SUBJECT:
                max = marks.stream().filter(el->el.getGender().equals(gender)).map(Mark::getSecondSubject).max((a, b)->a.compareTo(b)).orElse(-1);
                break;
            case THIRD_SUBJECT:
                max = marks.stream().filter(el->el.getGender().equals(gender)).map(Mark::getThirdSubject).max((a, b)->a.compareTo(b)).orElse(-1);
                break;
        }
        return max;
    }
    public static long getMinBySubjectGender(LinkedList<Mark> marks, String gender, MarkSubject markSubject){
        Integer min = -1;
        switch (markSubject) {
            case FIRST_SUBJECT:
                min = marks.stream().filter(el->el.getGender().equals(gender)).map(Mark::getFirstSubject).min((a, b)->a.compareTo(b)).orElse(-1);
                break;
            case SECOND_SUBJECT:
                min = marks.stream().filter(el->el.getGender().equals(gender)).map(Mark::getSecondSubject).min((a, b)->a.compareTo(b)).orElse(-1);
                break;
            case THIRD_SUBJECT:
                min = marks.stream().filter(el->el.getGender().equals(gender)).map(Mark::getThirdSubject).min((a, b)->a.compareTo(b)).orElse(-1);
                break;
        }
        return min;
    }
    public static LinkedList<Mark> getTopEducationState(LinkedList<Mark> marks, String education, String completed){
        LinkedList<Mark> top = marks.stream()
                .filter(el->el.getEducation().equals(education) && el.getCompleted().equals(completed))
                .sorted(Comparator.comparing(Mark::calculateAverage,Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toCollection(LinkedList::new));
        return top;
    }
    public static void part1(LinkedList<Mark> marks){
        HashSet<String> groups = getGroups(marks);
        HashSet<String> educations = getEducations(marks);
        for(String group: groups){
            for(String education: educations){
                System.out.println(String.format("Group %s, education %s:", group, education));
                System.out.println(String.format("Count: %s, average: %s", countByGroupEducation(marks,group,education), calculateAverageByGroupEducation(marks,group,education)));
            }
        }
    }
    public static void part2(LinkedList<Mark> marks){
        Gender gender = MarkInOut.getGender();
        MarkSubject subject = MarkInOut.getSubject();
        System.out.println("Results:");
        System.out.println(String.format("Max: %s, Min: %s", getMaxBySubjectGender(marks,gender.toString(),subject),getMinBySubjectGender(marks,gender.toString(), subject)));
    }
    public static void part3(LinkedList<Mark> marks){
        String education = MarkInOut.getEducation();
        LinkedList<Mark> top1 = getTopEducationState(marks, education, "completed");
        LinkedList<Mark> top2 = getTopEducationState(marks, education, "none");
        System.out.println("Completed:");
        top1.forEach(System.out::println);
        System.out.println("None:");
        top2.forEach(System.out::println);
    }
}
