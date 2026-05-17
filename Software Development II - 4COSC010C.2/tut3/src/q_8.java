import java.util.Scanner;
import java.util.Random;
public class q_8 {
    public static void main(String[] args) {
        int n = 1;
        while (n>0){
            Scanner obj = new Scanner(System.in);
            System.out.print("Guess a number between 1 and 20 : ");
            int user_number = obj.nextInt();

            Random rand = new Random();
            int random_number = rand.nextInt(20);

            if (random_number == user_number){
                System.out.print("You are correct");
                break;
            }
            else if (random_number!= user_number){
                System.out.print("Try again." + " ");
                continue;
            }
        }
    }
}