import java.util.Scanner;

public class W20532233_CinemaManagement {
    // The London Lumiere: 3 rows of 16 seats, with an aisle between seats 8 and 9
    static final int ROWS = 3;
    static final int SEATS_PER_ROW = 16;
    static final int[] ROW_PRICES = {12, 10, 8};    // row 1 £12, row 2 £10, row 3 £8

    // seats[row][seat]: 0 = available, 1 = sold
    static int[][] seats = new int[ROWS][SEATS_PER_ROW];

    // tickets[row][seat]: the ticket sold for that seat, or null. Same shape as seats,
    // so a seat's ticket is found directly instead of searching a list.
    static Ticket[][] tickets = new Ticket[ROWS][SEATS_PER_ROW];

    static Scanner user_input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to The London Lumiere"); // welcome message

        while (true) {
            print_menu();
            int option = read_int("Please select an option: ");
            switch (option) {
                case 1 -> buy_ticket();
                case 2 -> cancel_ticket();
                case 3 -> print_seating_area();
                case 4 -> find_first_available();
                case 5 -> print_tickets_info();
                case 6 -> search_ticket();
                case 7 -> sort_tickets();
                case 8 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                }
                default -> System.out.println("Enter a number between 1 and 8.");
            }
        }
    }

    static void print_menu() {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("-                  MENU OPTIONS                  -");
        System.out.println("--------------------------------------------------");
        System.out.println("     1) Buy a ticket");
        System.out.println("     2) Cancel a ticket");
        System.out.println("     3) See seating plan");
        System.out.println("     4) Find first seat available");
        System.out.println("     5) Print tickets information and total price");
        System.out.println("     6) Search ticket");
        System.out.println("     7) Sort tickets by price");
        System.out.println("     8) Exit");
        System.out.println("--------------------------------------------------");
    }

    static void buy_ticket() {
        int row = read_row();
        int seat = read_seat();

        if (seats[row][seat] == 1) {    // check the seat is not already sold
            System.out.println("Seat " + seat_name(row, seat) + " is not available.");
            return;
        }

        String name = read_text("Enter your first name: ");
        String surname = read_text("Enter your surname: ");
        String email = read_email();

        Person person = new Person(name, surname, email);
        Ticket ticket = new Ticket(row + 1, seat + 1, ROW_PRICES[row], person);

        seats[row][seat] = 1;
        tickets[row][seat] = ticket;
        System.out.println("Seat " + seat_name(row, seat) + " booked successfully.");
        ticket.printInfo();
        ticket.save();
    }

    static void cancel_ticket() {
        int row = read_row();
        int seat = read_seat();

        if (seats[row][seat] == 0) {
            System.out.println("Seat " + seat_name(row, seat) + " is not sold, so it cannot be cancelled.");
            return;
        }

        tickets[row][seat].deleteFile();
        tickets[row][seat] = null;
        seats[row][seat] = 0;
        System.out.println("Ticket for seat " + seat_name(row, seat) + " has been cancelled.");
    }

    // O = available, X = sold; the gap after seat 8 is the aisle
    static void print_seating_area() {
        System.out.println("Seating plan:");
        for (int row = 0; row < ROWS; row++) {
            System.out.print("Row " + (row + 1) + "  ");
            for (int seat = 0; seat < SEATS_PER_ROW; seat++) {
                System.out.print(seats[row][seat] == 1 ? "X " : "O ");
                if (seat == 7) {
                    System.out.print("  ");
                }
            }
            System.out.println(" £" + ROW_PRICES[row]);
        }
    }

    static void find_first_available() {
        for (int row = 0; row < ROWS; row++) {
            for (int seat = 0; seat < SEATS_PER_ROW; seat++) {
                if (seats[row][seat] == 0) {
                    System.out.println("The first available seat is " + seat_name(row, seat));
                    return;
                }
            }
        }
        System.out.println("Sorry, no seats are available.");
    }

    static void print_tickets_info() {
        Ticket[] sold = get_sold_tickets();
        print_tickets(sold);
    }

    static void search_ticket() {
        int row = read_row();
        int seat = read_seat();

        Ticket ticket = tickets[row][seat];
        if (ticket == null) {
            System.out.println("Seat " + seat_name(row, seat) + " is available.");
        } else {
            System.out.println("Seat " + seat_name(row, seat) + " is sold:");
            ticket.printInfo();
        }
    }

    // Prints the sold tickets from cheapest to most expensive (insertion sort on a copy,
    // so the seat grid itself is not changed)
    static void sort_tickets() {
        Ticket[] sold = get_sold_tickets();

        for (int i = 1; i < sold.length; i++) {
            Ticket current = sold[i];
            int j = i - 1;
            while (j >= 0 && sold[j].getPrice() > current.getPrice()) {
                sold[j + 1] = sold[j];
                j--;
            }
            sold[j + 1] = current;
        }

        System.out.println("Tickets sorted by price (lowest first):");
        print_tickets(sold);
    }

    // ---------- Helper methods ----------

    // Collects the sold tickets into an array of exactly the right size
    static Ticket[] get_sold_tickets() {
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int seat = 0; seat < SEATS_PER_ROW; seat++) {
                if (tickets[row][seat] != null) {
                    count++;
                }
            }
        }

        Ticket[] sold = new Ticket[count];
        int index = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int seat = 0; seat < SEATS_PER_ROW; seat++) {
                if (tickets[row][seat] != null) {
                    sold[index++] = tickets[row][seat];
                }
            }
        }
        return sold;
    }

    static void print_tickets(Ticket[] sold) {
        int total = 0;
        for (int i = 0; i < sold.length; i++) {
            System.out.println("---- Ticket " + (i + 1) + " ----");
            sold[i].printInfo();
            total += sold[i].getPrice();
        }
        if (sold.length == 0) {
            System.out.println("No tickets have been sold yet.");
        }
        System.out.println("Total price: £" + total);
    }

    static String seat_name(int row, int seat) {
        return "row " + (row + 1) + " seat " + (seat + 1);
    }

    // Asks for a row number until it is valid; returns the row index (row 1 = 0)
    static int read_row() {
        while (true) {
            int row = read_int("Enter the row number (1-" + ROWS + "): ");
            if (row >= 1 && row <= ROWS) {
                return row - 1;
            }
            System.out.println("Invalid row. Please enter a number from 1 to " + ROWS + ".");
        }
    }

    // Asks for a seat number until it is valid; returns the seat index (seat 1 = 0)
    static int read_seat() {
        while (true) {
            int seat = read_int("Enter the seat number (1-" + SEATS_PER_ROW + "): ");
            if (seat >= 1 && seat <= SEATS_PER_ROW) {
                return seat - 1;
            }
            System.out.println("Invalid seat. Please enter a number from 1 to " + SEATS_PER_ROW + ".");
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
