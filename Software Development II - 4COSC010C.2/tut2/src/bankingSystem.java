import java.util.Scanner;

public class bankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        final double FRAUD_THRESHOLD = 100;

        System.out.print("Enter your initial account balance: ");
        balance = scanner.nextDouble();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check for fraud");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.println("New balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount <= balance) {
                        balance -= withdrawalAmount;
                        System.out.println("New balance: $" + balance);
                    } else {
                        System.out.println("Insufficient funds for withdrawal.");
                        if (balance < 0) {
                            System.out.println("Overdraft warning: Balance is negative.");
                        }
                    }
                    break;
                case 3:
                    if (balance < FRAUD_THRESHOLD) {
                        System.out.println("Warning: Account balance is low. Be cautious of potential fraud.");
                    } else {
                        System.out.println("No fraud risk detected. Account balance is above threshold.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }
}
