import java.util.Scanner;

public class sum2Num{
    public static void main(String [] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the first number : ");
        double num1 = obj.nextDouble();
        System.out.println("Enter the second number : ");
        double num2 = obj.nextDouble();
        double total = num1 + num2;
        System.out.println("Total : " + total);

    }
}
