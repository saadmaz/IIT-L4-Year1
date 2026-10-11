import java.util.Scanner;

public class MetersToCentimeters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter distance in meters: ");
        double meters = scanner.nextDouble();

        double centimeters = meters * 100;

        System.out.println(meters + " meters is equal to " + centimeters + " centimeters.");
    }
}
