import java.util.Random;
import java.util.Scanner;

public class rockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("0 == Rock, 1 == Paper, 2 == Scissors");
        System.out.println("Enter your choice: ");
        int user_input = obj.nextInt();

        Random random = new Random();
        int random_number = random.nextInt(3);

        System.out.println("Computer's choice : " + random_number);
        System.out.println("Your choice : " + user_input);
        if (random_number==user_input && random_number==user_input && random_number==user_input){
            System.out.println("Game is tie");
        }
        if (random_number==0 && user_input==1 || random_number==1 && user_input==0){
            System.out.println("Paper covers Rock");
        }
        if (random_number==1 && user_input==2 || random_number==2 && user_input==1){
            System.out.println("Scissors cuts Paper");
        }
        if (random_number==2 && user_input==0 ||random_number==0 && user_input==2 ){
            System.out.println("Rock crushes Scissors");
        }
    }
}
