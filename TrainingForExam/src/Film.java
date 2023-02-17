import java.io.Console;
import java.lang.module.Configuration;

public class Film {

    private String title, subject, director;
    private Integer year, length, popularity;
    private Boolean awards;

    public Film(){
        this.year = Reader.year.get(Reader.year.size() - 1);
        this.length = Reader.length.get(Reader.length.size() - 1);
        this.title = Reader.title.get(Reader.title.size() - 1);
        this.subject = Reader.subject.get(Reader.subject.size() - 1);
        this.director = Reader.director.get(Reader.director.size() - 1);
        this.popularity = Reader.popularity.get(Reader.popularity.size() - 1);
        this.awards = Reader.awards.get(Reader.awards.size() - 1);
        Main.addFilm(getTitle(), getSubject(), getDirector(), getYear(), getLength(), getPopularity(), getAwards());
    }

    public Integer getYear(){
        return this.year;
    }

    public Integer getLength(){
        return this.length;
    }

    public Integer getPopularity(){
        return this.popularity;
    }

    public String getTitle(){
        return this.title;
    }

    public String getSubject(){
        return this.subject;
    }

    public String getDirector(){
        return this.director;
    }

    public Boolean getAwards(){
        return this.awards;
    }

    public void setYear(int yearSet){
        this.year = yearSet;
    }

    public void setLength(int lengthSet){
        this.length = lengthSet;
    }

    public void setPopularity(int popularitySet){
        this.popularity = popularitySet;
    }

    public void setTitle(String titleSet){
        this.title = titleSet;
    }

    public void setSubject(String subjectSet){
        this.subject = subjectSet;
    }

    public void setDirector(String directorSet){
        this.director = directorSet;
    }

    public void setAwards(Boolean awardsSet){
        this.awards = awardsSet;
    }
}