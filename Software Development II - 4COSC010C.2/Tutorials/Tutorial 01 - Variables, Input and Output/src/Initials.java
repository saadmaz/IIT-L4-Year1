import java.util.Scanner;

public class Initials {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();

      
        String firstLetterName = name.substring(0, 1).toUpperCase();
        String firstLetterSurname = surname.substring(0, 1).toUpperCase();

       
        System.out.println("Your initials are: " + firstLetterName + firstLetterSurname);
    }
}
