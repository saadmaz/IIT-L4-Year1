import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    private static Scanner input = new Scanner(System.in);

    // Global 2D array for hotel rooms
    // 0 = Available, 1 = Occupied
    private static int[][] rooms;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            HOTEL ROOM MANAGER");
        System.out.println("==================================================");
        System.out.println(" Welcome to the Hotel Room Manager");
        System.out.println(" Manage room occupancy and guest records");
        System.out.println("==================================================");

        initialiseRooms();
        runMenu();
    }

    public static void initialiseRooms() {

        rooms = new int[3][]; // 3 floors

        rooms[0] = new int[20]; // Floor 1 has 10 rooms
        rooms[1] = new int[25]; // Floor 2 has 15 rooms
        rooms[2] = new int[15]; // Floor 3 has 12 rooms

        // All rooms are automatically initialised to 0 (available)
    }

    public static void runMenu() {

        int option;

        do {
            option = getOption();

            switch (option) {
                case 1:
                    checkInGuest();
                    break;

                case 2:
                    checkOutGuest();
                    break;

                case 3:
                    showRooms();
                    break;

                case 0:
                    System.out.println("Thank you for using Hotel Room Manager.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 0);
    }

    public static int getOption() {

        System.out.println();
        System.out.println("+--------------------------------------+");
        System.out.println("|              MAIN MENU               |");
        System.out.println("+--------------------------------------+");
        System.out.println("| 1) Check in guest                    |");
        System.out.println("| 2) Check out guest                   |");
        System.out.println("| 3) Show room availability            |");
        System.out.println("| 0) Quit                              |");
        System.out.println("+--------------------------------------+");
        System.out.print("Please select an option: ");

        return input.nextInt();
    }

    public static void checkInGuest() {

        System.out.print("Enter floor number: ");
        int floorNumber = input.nextInt();

        System.out.print("Enter room number: ");
        int roomNumber = input.nextInt();

        int floorIndex = floorNumber - 1;
        int roomIndex = roomNumber - 1;

        if (rooms[floorIndex][roomIndex] == 0) {
            rooms[floorIndex][roomIndex] = 1;
            System.out.println("Check-in successful.");
        } else {
            System.out.println("Room already occupied.");
        }
    }

    public static void checkOutGuest() {

        System.out.print("Enter floor number: ");
        int floorNumber = input.nextInt();

        System.out.print("Enter room number: ");
        int roomNumber = input.nextInt();

        int floorIndex = floorNumber - 1;
        int roomIndex = roomNumber - 1;

        if (rooms[floorIndex][roomIndex] == 1) {
            rooms[floorIndex][roomIndex] = 0;
            System.out.println("Check-out successful.");
        } else {
            System.out.println("Room already available.");
        }
    }

    public static void showRooms() {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("HOTEL ROOM STATUS");
        System.out.println("==================================================");
        System.out.println("LEGEND: [O] = Available, [X] = Occupied");
        System.out.println("--------------------------------------------------");

        for (int floor = 0; floor < rooms.length; floor++) {

            System.out.print("Floor " + (floor + 1) + " ");

            for (int room = 0; room < rooms[floor].length; room++) {

                if (rooms[floor][room] == 0) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[X]");
                }
            }

            System.out.println();
        }

        System.out.println("==================================================");
    }
}