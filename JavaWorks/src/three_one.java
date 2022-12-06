import java.util.Scanner;

public class three_one {

    public static void main(String[] args) {
        int[] a;
        int[] b;
        a = new int[5];
        b = new int[5];
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < 5; i++){
            b[i] = in.nextInt();
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(a[i] == b[j]){
                    System.out.print(a[i]);
                    System.out.print(" ");
                }
            }
        }
    }
}
