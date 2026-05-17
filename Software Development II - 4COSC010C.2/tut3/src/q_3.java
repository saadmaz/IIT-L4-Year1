import java.util.Scanner;

public class q_3 {
    public static void main(String [] args ){
        Scanner obj = new Scanner (System.in);

        System.out.print("Enter a number : ");
        int num = obj.nextInt();

        System.out.print("Enter a letter : ");
        String le = obj.next();

        System.out.print("Output : ");
        int count = 0;
        while(count<num){
            System.out.print(le);
            count++;
        }
    }
}
