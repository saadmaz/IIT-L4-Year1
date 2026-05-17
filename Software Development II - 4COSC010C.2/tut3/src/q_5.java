import java.util.Scanner;
public class q_5 {
    public static void main (String[] args){
        Scanner obj = new Scanner (System.in);
        System.out.print("Enter a number = ");
        int number = obj.nextInt();
        int n = number;
        int a = 1;
        int b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
