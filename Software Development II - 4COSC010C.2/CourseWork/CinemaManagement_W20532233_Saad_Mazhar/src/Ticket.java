import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// A ticket for one cinema seat, sold to one person
public class Ticket {
    private int row;        // row number, starting at 1
    private int seat;       // seat number, starting at 1
    private int price;      // price in £
    private Person person;  // ticket holder

    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Prints the ticket and the ticket holder's details
    public void printInfo() {
        System.out.println("Row: " + row + ", Seat: " + seat);
        System.out.println("Price: £" + price);
        person.printInfo();
    }

    // Saves the ticket to a text file named after the seat, e.g. "1_5.txt" for row 1 seat 5
    public void save() {
        try (FileWriter writer = new FileWriter(getFileName())) {
            writer.write("Ticket information\n");
            writer.write("Row: " + row + "\n");
            writer.write("Seat: " + seat + "\n");
            writer.write("Price: £" + price + "\n");
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurname() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
            System.out.println("Ticket saved to " + getFileName());
        } catch (IOException e) {
            System.out.println("Could not save the ticket file: " + e.getMessage());
        }
    }

    // Deletes the ticket file when the ticket is cancelled
    public void deleteFile() {
        File file = new File(getFileName());
        if (file.exists() && !file.delete()) {
            System.out.println("Could not delete " + getFileName());
        }
    }

    private String getFileName() {
        return row + "_" + seat + ".txt";
    }
}
