// Program C
import java.util.Scanner;
class TestPositive {
    public static void main(String [] args) {
        Scanner S = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int x = S.nextInt();
        if (x > 0) {
            System.out.println("The value is positive:");
        }
        if (x < 0) {
            System.out.println("The value is negative:");
        }
        if (x ==0) {
            System.out.println("The value is zero:");
        }
        System.out.println("Good Bye!");
    }
}