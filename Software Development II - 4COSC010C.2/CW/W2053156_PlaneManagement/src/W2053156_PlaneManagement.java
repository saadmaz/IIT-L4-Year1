import java.util.Scanner;

public class W2053156_PlaneManagement {

    // Plane layout: rows A-D, rows A and D have 14 seats, rows B and C have 12
    private static final int ROWS = 4;
    private static final int[] SEATS_IN_ROW = {14, 12, 12, 14};

    // seats[row][seat] is 0 when available and 1 when sold
    private static final int[][] seats = new int[ROWS][];
    // tickets[row][seat] holds the sold ticket, or null; same shape as seats
    private static final Ticket[][] tickets = new Ticket[ROWS][];

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < ROWS; i++) {
            seats[i] = new int[SEATS_IN_ROW[i]];
            tickets[i] = new Ticket[SEATS_IN_ROW[i]];
        }

        System.out.println("Welcome to the Plane Management application");
        while (true) {
            printMenu();
            switch (readInt("Please select an option: ")) {
                case 1 -> buySeat();
                case 2 -> cancelSeat();
                case 3 -> findFirstAvailable();
                case 4 -> showSeatingPlan();
                case 5 -> printTicketsInfo();
                case 6 -> searchTicket();
                case 0 -> {
                    System.out.println("Exiting the program. Thank you!");
                    return;
                }
                default -> System.out.println("Invalid option. Please enter a number from 0 to 6.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("*                 MENU OPTIONS                  *");
        System.out.println("*************************************************");
        System.out.println("    1) Buy a seat");
        System.out.println("    2) Cancel a seat");
        System.out.println("    3) Find first available seat");
        System.out.println("    4) Show seating plan");
        System.out.println("    5) Print tickets information and total sales");
        System.out.println("    6) Search ticket");
        System.out.println("    0) Quit");
        System.out.println("*************************************************");
    }

    // ---------- Menu options ----------

    private static void buySeat() {
        int row = readRow();
        int seat = readSeat(row);
        if (seats[row][seat] == 1) {
            System.out.println("Seat " + label(row, seat) + " is already sold.");
            return;
        }

        String name = readText("Enter your name: ");
        String surname = readText("Enter your surname: ");
        String email = readEmail();

        Ticket ticket = new Ticket(rowLetter(row), seat + 1, getPrice(seat), new Person(name, surname, email));
        ticket.save();
        tickets[row][seat] = ticket;
        seats[row][seat] = 1;
        System.out.println("Seat " + label(row, seat) + " booked successfully. Price: £" + ticket.getPrice());
    }

    private static void cancelSeat() {
        int row = readRow();
        int seat = readSeat(row);
        if (seats[row][seat] == 0) {
            System.out.println("Seat " + label(row, seat) + " is not booked.");
            return;
        }

        tickets[row][seat].deleteFile();
        tickets[row][seat] = null;
        seats[row][seat] = 0;
        System.out.println("Seat " + label(row, seat) + " cancelled successfully.");
    }

    private static void findFirstAvailable() {
        for (int row = 0; row < ROWS; row++) {
            for (int seat = 0; seat < SEATS_IN_ROW[row]; seat++) {
                if (seats[row][seat] == 0) {
                    System.out.println("First available seat: " + label(row, seat));
                    return;
                }
            }
        }
        System.out.println("No available seats. The plane is fully booked.");
    }

    // O = available, X = sold
    private static void showSeatingPlan() {
        for (int row = 0; row < ROWS; row++) {
            System.out.print(rowLetter(row) + "  ");
            for (int seat = 0; seat < SEATS_IN_ROW[row]; seat++) {
                System.out.print(seats[row][seat] == 0 ? "O " : "X ");
            }
            System.out.println();
        }
    }

    private static void printTicketsInfo() {
        double totalSales = 0;
        boolean anySold = false;
        for (Ticket[] rowTickets : tickets) {
            for (Ticket ticket : rowTickets) {
                if (ticket != null) {
                    System.out.println("-------------------------");
                    ticket.printInfo();
                    totalSales += ticket.getPrice();
                    anySold = true;
                }
            }
        }
        if (!anySold) {
            System.out.println("No tickets have been sold yet.");
        }
        System.out.println("Total sales: £" + totalSales);
    }

    private static void searchTicket() {
        int row = readRow();
        int seat = readSeat(row);
        Ticket ticket = tickets[row][seat];
        if (ticket == null) {
            System.out.println("Seat " + label(row, seat) + " is available.");
        } else {
            ticket.printInfo();
        }
    }

    // ---------- Helpers ----------

    // Seats 1-5 cost £200, 6-9 cost £150 and 10-14 cost £180 (seat is 0-based)
    private static double getPrice(int seat) {
        if (seat < 5) {
            return 200;
        } else if (seat < 9) {
            return 150;
        }
        return 180;
    }

    private static char rowLetter(int row) {
        return (char) ('A' + row);
    }

    private static String label(int row, int seat) {
        return rowLetter(row) + Integer.toString(seat + 1);
    }

    // ---------- Input (all input is read line by line, so bad input never leaves junk in the scanner) ----------

    // Returns the 0-based row index
    private static int readRow() {
        while (true) {
            String input = readText("Enter the row letter (A-D): ").toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) < 'A' + ROWS) {
                return input.charAt(0) - 'A';
            }
            System.out.println("Invalid row. Please enter A, B, C or D.");
        }
    }

    // Returns the 0-based seat index for the given row
    private static int readSeat(int row) {
        int max = SEATS_IN_ROW[row];
        while (true) {
            int seat = readInt("Enter the seat number (1-" + max + "): ");
            if (seat >= 1 && seat <= max) {
                return seat - 1;
            }
            System.out.println("Invalid seat number. Row " + rowLetter(row) + " has seats 1 to " + max + ".");
        }
    }

    private static String readEmail() {
        while (true) {
            String email = readText("Enter your email: ");
            if (email.contains("@") && email.contains(".") && !email.contains(" ")) {
                return email;
            }
            System.out.println("Invalid email address. Please try again.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readText(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    // Reads a non-empty line
    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                System.out.println();
                System.exit(0); // input closed
            }
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
        }
    }
}
