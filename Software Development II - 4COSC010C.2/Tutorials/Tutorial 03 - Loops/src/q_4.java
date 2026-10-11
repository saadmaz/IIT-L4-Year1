import java.util.Scanner;
public class q_4 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter a positive number : ");
        int number = obj.nextInt();

        if (number < 0) {
            System.out.println("Enter a correct number");
        }
        if (number == 0){
            System.out.println("Factorial of 0 is 1");
        }
        else {
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.print("Factorial of " + number + " = " + factorial + ".");
        }
    }
}
