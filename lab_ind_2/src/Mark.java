import java.util.ArrayList;

public class Mark {
    private String gender;
    private String group;
    private String education;
    private String state;
    private String completed;
    private Integer firstSubject;
    private Integer secondSubject;
    private Integer thirdSubject;

    public Mark(
        String gender,
        String group,
        String education,
        String state,
        String completed,
        Integer firstSubject,
        Integer secondSubject,
        Integer thirdSubject
    ) {
        this.gender = gender;
        this.group = group;
        this.education = education;
        this.state = state;
        this.completed = completed;
        this.firstSubject = firstSubject;
        this.secondSubject = secondSubject;
        this.thirdSubject = thirdSubject;
    }
    public Double calculateAverage(){
        return (Double.valueOf(firstSubject) + Double.valueOf(secondSubject) + Double.valueOf(thirdSubject))/3;
    }
    public String getGroup(){
        return this.group;
    }
    public String getEducation(){
        return this.education;
    }
    public String getGender(){
        return this.gender;
    }
    public String getState(){
        return this.state;
    }
    public String getCompleted(){return this.completed;}
    public Integer getFirstSubject(){
        return this.firstSubject;
    }
    public Integer getSecondSubject(){
        return this.secondSubject;
    }
    public Integer getThirdSubject(){
        return this.thirdSubject;
    }
    public String toString(){
        return String.format("Mark: %s, %s, %s, %s, %s, %s",group, education, state, firstSubject,secondSubject,thirdSubject);
    }
}
