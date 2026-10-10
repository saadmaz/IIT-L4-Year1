package cli;

import java.util.Scanner;
public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public void setupConfiguration() {
        Scanner scanner = new Scanner(System.in);

        this.totalTickets = getIntInput(scanner, "Configure the total number of tickets: ");
        this.ticketReleaseRate = getIntInput(scanner, "Configure the ticket release rate (tickets per second): ");
        this.customerRetrievalRate = getIntInput(scanner,
                "Configure the customer retrieval rate (tickets per second): ");
        this.maxTicketCapacity = getIntInput(scanner, "Configure the maximum ticket capacity: ");
    }

    private int getIntInput(Scanner scanner, String prompt) {
        int input = -1;
        while (input < 0) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 0) {
                    System.out.println("The value must be positive.");
                    System.out.println("Please enter again :");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }

    // Getters for configuration parameters
    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    // Setters for configuration parameters
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}