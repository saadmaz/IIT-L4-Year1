import java.util.InputMismatchException;
import java.util.Scanner;
public class W2053223_PlaneManagement {
    // Define arrays
    static int[][] seats = new int[4][14];


    static Scanner user_input = new Scanner(System.in);

    public static Ticket[] sold = new Ticket[100];
    public static int sold_count = 0;

    //main method
    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application"); //welcome message
        Menu();
    }
    //menu method
    static void Menu() {
        System.out.println("************************************************");
        System.out.println("*                 MENU OPTIONS                  *");
        System.out.println("************************************************");
        System.out.println("     1) Buy a seat");
        System.out.println("     2) Cancel a seat");
        System.out.println("     3) Find first available seat");
        System.out.println("     4) Show seating plan");
        System.out.println("     5) Print ticket information and total sales");
        System.out.println("     6) Search tickets");
        System.out.println("     0) Quit");
        System.out.println("************************************************");
        System.out.println("Please select a option: ");
        int option = user_input.nextInt();  //get input

        if (option <= 6 && option >= 0) {   //checking if the user input is in the correct range
            switch (option) {
                case 0:
                    System.out.println("exit your programme");
                    System.exit(0);
                case 1:
                    buy_seat();  //if user input is 1
                    skip();
                    break;

                case 2:
                    cancel_seat();    //if user input is 2
                    skip();
                    break;

                case 3:
                    find_first_available();     //if user input is 3
                    skip();
                    break;

                case 4:
                    show_seating_plan();    //if user input is 4
                    skip();
                    break;

                case 5:
                    print_tickets_info();     //if user input is 5
                    skip();
                    break;

                case 6:
                    search_tickets();     //if user input is 6
                    skip();
                    break;

            }
        }else{
            System.out.println("Enter a number between 0 and 6");
            Menu();
        }
    }


    //call buy_seat
    static void buy_seat() {
        while (true) {
            System.out.println("Enter your preferred row (A, B, C, D)");   //ask user the preferred row
            String row_letter = user_input.next().toUpperCase();    //uppercase

            if (row_letter.matches("[ABCD]")) {    //check if input is within the range (A,B,C or D)
                details_buy(row_letter);    //call the details_buy

                break;

            } else {
                System.out.println("Invalid row letter. Please enter A, B, C, or D.");
            }
        }
    }


    //calling details_buy method
    static void details_buy(String row_letter) {
        int column_number;  //initialize variables
        int seatPrice;

        if (row_letter.equalsIgnoreCase("A") || row_letter.equalsIgnoreCase("D")) {     //check if row letter is A or B
            while (true) {
                System.out.println("Enter your preferred column (1-14): ");     //input preferred column number
                try{
                    if (user_input.hasNextInt()) {
                        column_number = user_input.nextInt();
                        if (column_number >= 1 && column_number <= 14) {      // check the column number is in range (1 - 14)
                            break;
                        } else {
                            System.out.println("Invalid column number. Please enter a number between 1 and 14.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        user_input.next(); // Consume the invalid input
                    }
                }catch(Exception e){
                    System.out.println("Error");
                }
            }
        } else if (row_letter.equalsIgnoreCase("B") || row_letter.equalsIgnoreCase("C")) {    //check if row letter is b or c
            while (true) {
                System.out.println("Enter your preferred column (1-12): ");
                if (user_input.hasNextInt()) {
                    column_number = user_input.nextInt();
                    if (column_number >= 1 && column_number <= 12) {    // check if the column number is in range (1 to 12)
                        break;
                    } else {
                        System.out.println("Invalid column number. Please enter a number between 1 and 12.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    user_input.next(); // Consume the invalid input
                }
            }
        } else {
            System.out.println("Invalid row letter");    //if it is not equal a,b,c,d; print that
            return; // Exit the method if the row letter is invalid
        }

        user_input.nextLine();
        //input the name, surname and email from the user
        System.out.print("Enter your first name: ");
        String f_name = user_input.next();
        System.out.print("Enter your surname: ");
        String s_name = user_input.next();
        System.out.print("Enter your email: ");
        String email = user_input.next();

        //connect the person class
        Person person = new Person(f_name, s_name, email);

        // Calculate seat price based on the column number
        if (column_number <= 5) {
            seatPrice = 200;
        } else if (column_number <= 9) {
            seatPrice = 150;
        } else {
            seatPrice = 180;
        }

        int row_index = row_letter.charAt(0) - 'A';
        seats[row_index][column_number - 1] = 1;

        //ticket details
        Ticket ticket = new Ticket(row_letter, column_number, seatPrice, person);
        sold[sold_count++] = ticket;

        ticket.printTicketInfo();

        ticket.save();     //save the ticket details
    }
    //calling cancel_seat
    static void cancel_seat() {
        Scanner user_input = new Scanner(System.in);

        System.out.println("Enter your row letter (A-D):");
        String row_letter = user_input.nextLine().toUpperCase(); // Convert to uppercase for case-insensitive comparison

        if (!row_letter.matches("[A-D]")) { // Check for valid row letter (A-D)
            System.out.println("Invalid row letter. Please enter A, B, C, or D.");
            return;
        }

        System.out.println("Enter your column number:");

        int column_number;    //initialize variable
        try {
            column_number = user_input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the column number.");
            user_input.nextLine(); // Consume remaining newline character
            return;
        }

        int seat_index = row_letter.charAt(0) - 'A'; // Convert row letter to index (A=0, B=1, ...)

        // Check if the seat is sold (assuming seats[seat_index][column_number - 1] == 1 indicates sold seat)
        if (seats[seat_index][column_number - 1] == 1) {
            seats[seat_index][column_number - 1] = 0; // Mark seat as available

            // Remove the canceled ticket from the sold array
            boolean ticketFound = false;
            for (int i = 0; i < sold_count; i++) {
                Ticket ticket = sold[i];
                if (ticket.get_row().equals(row_letter) && ticket.get_seat() == column_number) {
                    // Shift elements to remove the canceled ticket
                    for (int j = i; j < sold_count - 1; j++) {
                        sold[j] = sold[j + 1];
                    }
                    sold_count--;
                    ticketFound = true;
                    break; // Exit loop after finding a match
                }
            }
            //print cancel seat number
            if (ticketFound) {
                System.out.println("Ticket for seat " + row_letter + column_number + " has been cancelled.");
            } else {
                System.out.println("No ticket found for seat " + row_letter + column_number);
            }
        } else {
            System.out.println("The seat " + row_letter + column_number + " is available.");

        }
    }

    // calling find_first_available method
    static void find_first_available() {
        while(true){
            String[] row_letter = {"A", "B", "C", "D"};     //row letter

            for (int i = 0; i < row_letter.length; i++) {    // It iterates through the rows and columns of the seats array,
                String letter = row_letter[i];
                for (int j = 0; j < seats[i].length; j++) {
                    if (seats[i][j]==(0)) {
                        System.out.println("The first available seat is " + letter + (j + 1));     // If an available seat is found, it prints its location (row letter + seat number).
                        return;
                    }
                }
            }System.out.println("Sorry, no seats available to select!");
        }
    }
    //calling show_seating_plan method
    static void show_seating_plan() {

        System.out.println("Seating Plan:");
        for (int i = 0; i < seats.length; i++){
            char row = (char) ('A' + i);
            System.out.print(row + " ");
            // Adjust the loop condition for printing seats based on the row

            int seatCount = (i == 1 || i ==2) ? 12 : 14;
            for (int j = 0; j < seatCount; j++) {
                if (seats[i][j] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();

        }
    }

    //calling print ticket info method
    static void print_tickets_info() {
        while (true) {
            int total_sales = 0;
            System.out.println("Ticket information");

            // Iterate through each sold ticket
            for (int i = 0; i < sold_count; i++) {
                Ticket ticket = sold[i];

                System.out.println("Ticket " + (i + 1) + ":");
                ticket.printTicketInfo(); // Print details of the ticket

                total_sales += ticket.get_price(); // Accumulate total sales
            }

            // Print total sales
            System.out.println("Total sales: £" + total_sales);
            Menu();

        }
    }

    static void search_tickets() {
        while (true) {
            // Prompt the user to enter a row letter (A, B, C, D)
            System.out.println("Enter row letter (A, B, C, D): ");
            String row = user_input.next().toUpperCase();

            // Validate the row input
            if (!row.matches("[ABCD]")) {
                System.out.println("Invalid row. Please enter A, B, C, or D.");
                return; // Exit the method
            }

            // Determine the maximum seat number based on the row
            int maxSeat = (row.equals("A") || row.equals("D")) ? 14 : 12;

            // Prompt the user to enter the seat number (1-maxSeat)
            System.out.println("Enter the seat number (1-" + maxSeat + "): ");
            int seat_no = user_input.nextInt();

            // Validate the seat number input
            if (seat_no < 1 || seat_no > maxSeat) {
                System.out.println("Invalid seat number for row " + row);
                return; // Exit the method
            }

            // Check if the seat is sold
            if (seats[row.charAt(0) - 'A'][seat_no - 1] == 1) {
                // Seat is sold, find the corresponding ticket
                for (Ticket ticket : sold) {
                    if (ticket.get_row().equals(row) && ticket.get_seat() == seat_no) {
                        System.out.println("Ticket information:");
                        ticket.printTicketInfo();
                        return; // Exit the method
                    }
                }
            } else {
                System.out.println("This seat is available.");
                Menu();
            }
        }
    }
    static void skip() {
        System.out.println("Press 1 to go back to the main menu"); //go to the main menu
        System.out.println("Press 0 to quit the program ");  //quit the program
        System.out.println("Enter your choice: ");
        int choice = user_input.nextInt();  //input

        if (choice == 1) {  //if 1; go to menu
            Menu();
        } else if (choice == 0) {   //if 0; end the program
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Exiting the program."); //print invalid
            System.exit(0);

        }
    }
}