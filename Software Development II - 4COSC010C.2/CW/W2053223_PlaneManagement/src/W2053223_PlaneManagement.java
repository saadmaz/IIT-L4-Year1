import java.util.Scanner;

public class W2053223_PlaneManagement {
    // Rows A and D have 14 seats, rows B and C have 12
    static final char[] ROW_LETTERS = {'A', 'B', 'C', 'D'};

    // seats[row][seat]: 0 = available, 1 = sold
    static int[][] seats = {new int[14], new int[12], new int[12], new int[14]};

    // tickets[row][seat]: the ticket sold for that seat, or null. Same shape as seats,
    // so a seat's ticket is found directly instead of searching a list.
    static Ticket[][] tickets = {new Ticket[14], new Ticket[12], new Ticket[12], new Ticket[14]};

    static Scanner user_input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application"); // welcome message

        while (true) {
            print_menu();
            int option = read_int("Please select an option: ");
            switch (option) {
                case 1 -> buy_seat();
                case 2 -> cancel_seat();
                case 3 -> find_first_available();
                case 4 -> show_seating_plan();
                case 5 -> print_tickets_info();
                case 6 -> search_ticket();
                case 0 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                }
                default -> System.out.println("Enter a number between 0 and 6.");
            }
        }
    }

    static void print_menu() {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*                 MENU OPTIONS                 *");
        System.out.println("************************************************");
        System.out.println("     1) Buy a seat");
        System.out.println("     2) Cancel a seat");
        System.out.println("     3) Find first available seat");
        System.out.println("     4) Show seating plan");
        System.out.println("     5) Print tickets information and total sales");
        System.out.println("     6) Search ticket");
        System.out.println("     0) Quit");
        System.out.println("************************************************");
    }

    static void buy_seat() {
        int row = read_row();
        int seat = read_seat(row);

        if (seats[row][seat] == 1) {    // check the seat is not already sold
            System.out.println("Seat " + seat_name(row, seat) + " is already sold.");
            return;
        }

        String name = read_text("Enter your first name: ");
        String surname = read_text("Enter your surname: ");
        String email = read_email();

        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(ROW_LETTERS[row], seat + 1, get_price(seat), person);

        seats[row][seat] = 1;
        tickets[row][seat] = ticket;
        System.out.println("Seat " + seat_name(row, seat) + " booked successfully.");
        ticket.printInfo();
        ticket.save();
    }

    static void cancel_seat() {
        int row = read_row();
        int seat = read_seat(row);

        if (seats[row][seat] == 0) {
            System.out.println("Seat " + seat_name(row, seat) + " is not sold, so it cannot be cancelled.");
            return;
        }

        tickets[row][seat].deleteFile();
        tickets[row][seat] = null;
        seats[row][seat] = 0;
        System.out.println("Ticket for seat " + seat_name(row, seat) + " has been cancelled.");
    }

    static void find_first_available() {
        for (int row = 0; row < seats.length; row++) {
            for (int seat = 0; seat < seats[row].length; seat++) {
                if (seats[row][seat] == 0) {
                    System.out.println("The first available seat is " + seat_name(row, seat));
                    return;
                }
            }
        }
        System.out.println("Sorry, no seats are available.");
    }

    // O = available, X = sold
    static void show_seating_plan() {
        System.out.println("Seating plan:");
        for (int row = 0; row < seats.length; row++) {
            System.out.print(ROW_LETTERS[row] + " ");
            for (int seat = 0; seat < seats[row].length; seat++) {
                System.out.print(seats[row][seat] == 1 ? "X" : "O");
            }
            System.out.println();
        }
    }

    static void print_tickets_info() {
        int total_sales = 0;
        int count = 0;

        for (Ticket[] row_tickets : tickets) {
            for (Ticket ticket : row_tickets) {
                if (ticket != null) {
                    count++;
                    System.out.println("---- Ticket " + count + " ----");
                    ticket.printInfo();
                    total_sales += ticket.getPrice();
                }
            }
        }

        if (count == 0) {
            System.out.println("No tickets have been sold yet.");
        }
        System.out.println("Total sales: £" + total_sales);
    }

    static void search_ticket() {
        int row = read_row();
        int seat = read_seat(row);

        Ticket ticket = tickets[row][seat];
        if (ticket == null) {
            System.out.println("Seat " + seat_name(row, seat) + " is available.");
        } else {
            System.out.println("Seat " + seat_name(row, seat) + " is sold:");
            ticket.printInfo();
        }
    }

    // ---------- Helper methods ----------

    // Seats 1-5 cost £200, seats 6-9 £150, seats 10-14 £180 (seat is the 0-based index)
    static int get_price(int seat) {
        if (seat < 5) {
            return 200;
        } else if (seat < 9) {
            return 150;
        }
        return 180;
    }

    static String seat_name(int row, int seat) {
        return "" + ROW_LETTERS[row] + (seat + 1);
    }

    // Asks for a row letter until it is valid; returns the row index (A = 0)
    static int read_row() {
        while (true) {
            String input = read_text("Enter the row letter (A, B, C, D): ").toUpperCase();
            if (input.matches("[A-D]")) {
                return input.charAt(0) - 'A';
            }
            System.out.println("Invalid row letter. Please enter A, B, C or D.");
        }
    }

    // Asks for a seat number valid for the given row; returns the seat index (seat 1 = 0)
    static int read_seat(int row) {
        int max = seats[row].length;
        while (true) {
            int seat = read_int("Enter the seat number (1-" + max + "): ");
            if (seat >= 1 && seat <= max) {
                return seat - 1;
            }
            System.out.println("Invalid seat number. Row " + ROW_LETTERS[row] + " has seats 1 to " + max + ".");
        }
    }

    static String read_email() {
        while (true) {
            String email = read_text("Enter your email: ");
            if (email.matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
                return email;
            }
            System.out.println("Invalid email address. Please try again.");
        }
    }

    // Reads a whole number, asking again on invalid input
    static int read_int(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(read_text(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Reads a non-empty line. Reading whole lines avoids leftover input breaking the next question.
    static String read_text(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!user_input.hasNextLine()) {
                System.exit(0); // input closed
            }
            String line = user_input.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
        }
    }
}
