import java.util.Scanner;

public class CelsiusToFahrenheit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (9.0 / 5) * celsius + 32;

        System.out.println(celsius + "°C is equal to " + fahrenheit + "°F.");
    }
}
