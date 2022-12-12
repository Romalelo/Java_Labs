import java.util.Scanner;

public class four {

    public static boolean IfInTime(int monthOne, int dayOne, int monthTwo, int dayTwo){
        if(monthOne==monthTwo){
            if(dayOne>=dayTwo){
                System.out.println("Сдал вовремя");
                return true;
            }
            else {
                System.out.println("Сдал не вовремя");
                return false;
            }
        }
        if(monthOne>monthTwo){
            System.out.println("Сдал вовремя");
            return true;
        }
        else {
            System.out.println("Сдал не вовремя");
            return false;
        }
    }

    public static void main(String[] args){

        int month, day;

        book one = new book();
        one.setName("Java 8. Полное руководство");
        one.setAuthor("Г.Шилдт");
        one.setDay(1);
        one.setMonth(4);

        book two = new book();
        two.setName("Крейцерова соната");
        two.setAuthor("Л.Толстой");
        two.setDay(25);
        two.setMonth(3);

        reader Petrov = new reader();
        Petrov.setName("Петров");
        Petrov.setBookName("Java 8. Полное руководство");

        reader Vasechkin = new reader();
        Vasechkin.setName("Васечкин");
        Vasechkin.setBookName("Крейцерова соната");

        Scanner in = new Scanner(System.in);

        System.out.println("Введите месяц:");
        month = in.nextInt();
        System.out.println("Введите день:");
        day = in.nextInt();

        System.out.print(Petrov.getName() + " ");
        IfInTime(one.getMonth(), one.getDay(), month, day);

        System.out.print(Vasechkin.getName() + " ");
        IfInTime(two.getMonth(), two.getDay(), month, day);
    }
}

class book{
    private int day, month;
    private String name, author;

    void setDay(int a){
        day = a;
    }

    void setMonth(int a){
        month = a;
    }

    void setName(String a){
        name = a;
    }

    void setAuthor(String a){
        author = a;
    }

    int getDay(){
        return day;
    }

    int getMonth(){
        return month;
    }

    String getName(){
        return name;
    }

    String getAuthor(){
        return author;
    }
}

class reader{
    private String name, bookName;

    void setName(String a){
        name = a;
    }

    void setBookName(String a){
        bookName = a;
    }

    String getName(){
        return name;
    }

    String getBookName(){
        return bookName;
    }
}