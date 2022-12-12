import java.util.ArrayList;
import java.util.List;

public class five {

    public static void main(String[] args){

    }
}

class human{

    int age;
    String name, sex;


    public void setName(String a){
        name = a;
    }

    public void setSex(String a){
        sex = a;
    }

    public void setAge(int a){
        age = a;
    }

    public String getName(){
        return name;
    }

    public String getSex(){
        return sex;
    }

    public int getAge(){
        return age;
    }


}

class schoolboy extends human{

    int math, russ, hist, engl;
    public List<Integer> othe = new ArrayList<>();
    boolean OblOlimp, FirstSchoolOlimp, PrizeCityOlimp;

    public void setMath(int a){
        math = a;
    }

    public void setRuss(int a){
        russ = a;
    }

    public void setHist(int a){
        hist = a;
    }

    public void setEngl(int a){
        engl = a;
    }

    public void setOthe(int a){
        othe.add(a);
    }

    public void setOblOlimp(boolean a){
        OblOlimp = a;
    }

    public void setFirstSchoolOlimp(boolean a){
        FirstSchoolOlimp = a;
    }

    public void setPrizeCityOlimp(boolean a){
        PrizeCityOlimp = a;
    }

    public int getMath(){
        return math;
    }

    public int getRuss(){
        return russ;
    }

    public int getHist(){
        return hist;
    }

    public int getEngl(){
        return engl;
    }

    public List<Integer> getOthe(){
        return othe;
    }

    public boolean getOblOlimp(){
        return OblOlimp;
    }

    public boolean getFirstSchoolOlimp(){
        return FirstSchoolOlimp;
    }

    public boolean getPrizeCityOlimp(){
        return PrizeCityOlimp;
    }
}

class student extends human{

    public List<Integer> marks = new ArrayList<>();
    public List<Integer> kurs = new ArrayList<>();

    public void setMarks(int a){
        marks.add(a);
    }

    public void setKurs(int a){
        kurs.add(a);
    }

    public List<Integer> getMarks(){
        return marks;
    }

    public List<Integer> getKurs(){
        return kurs;
    }

}