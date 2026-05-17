import java.util.Scanner;
public class q_7 {
    public static void main(String[] args) {
        for (int i = 3; i >= 0; i--) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your password : ");
            int password = input.nextInt();
            int correct_password = 486251;
            if (password != correct_password) {
                System.out.println("Enter your password again");
                System.out.println("You have " + i + " attempts ");
                continue;
            }
            else if (password == correct_password){
                System.out.println("Correct password");
                break;
            }
        }
    }
}
