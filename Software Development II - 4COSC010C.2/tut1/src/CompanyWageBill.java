import java.util.Scanner;

public class CompanyWageBill {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of Manual employees: ");
        int manualCount = scanner.nextInt();

        System.out.print("Enter number of Skilled employees: ");
        int skilledCount = scanner.nextInt();

        System.out.print("Enter number of Management employees: ");
        int managementCount = scanner.nextInt();

        double manualSalary = 500.0;
        double skilledSalary = 700.0;
        double managementSalary = 800.0;

        // Calculate total wage bill
        double totalWageBill = manualCount * manualSalary + skilledCount * skilledSalary + managementCount * managementSalary;

        double tax = totalWageBill * 0.2;

        System.out.println("Total wage bill: £" + totalWageBill);
        System.out.println("Approximate tax to pay: £" + tax);
    }
}
