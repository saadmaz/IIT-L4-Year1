import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// A ticket for one seat, sold to one person
public class Ticket {
    private char row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(char row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Seat label such as "A5"; also used as the ticket's file name
    public String getSeatLabel() {
        return row + Integer.toString(seat);
    }

    // Prints the ticket and the person's details
    public void printInfo() {
        System.out.println("Seat: " + getSeatLabel());
        System.out.println("Price: £" + price);
        person.printInfo();
    }

    // Saves the ticket to a text file named after the seat, e.g. "A5.txt"
    public void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFileName()))) {
            writer.println("Seat: " + getSeatLabel());
            writer.println("Price: £" + price);
            writer.println("Person: " + person.getFullName());
            writer.println("Email: " + person.getEmail());
        } catch (IOException e) {
            System.out.println("Could not save ticket file " + getFileName() + ": " + e.getMessage());
        }
    }

    // Removes the ticket's file when the seat is cancelled
    public void deleteFile() {
        File file = new File(getFileName());
        if (file.exists() && !file.delete()) {
            System.out.println("Could not delete ticket file " + getFileName() + ".");
        }
    }

    private String getFileName() {
        return getSeatLabel() + ".txt";
    }
}
