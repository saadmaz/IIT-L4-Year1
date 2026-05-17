import java.io.File;
import java.util.InputMismatchException;
import java.io.*;
public class Ticket {
    // Fields
    private String row; // The row of the seat
    private int seat; // The seat number
    private int price; // The price of the ticket
    private Person person; // Information about the ticket holder (a Person object)

    // Constructor
    public Ticket(String row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getter for row
    public String get_row() {
        return row;
    }

    // Setter for row
    public void set_row(String row) {
        this.row = row;
    }

    // Getter for price
    public int get_price() {
        return price;
    }

    // Setter for price
    public void set_price(int price) {
        this.price = price;
    }

    // Getter for seat
    public int get_seat() {
        return seat;
    }

    // Setter for seat
    public void set_seat(int seat) {
        this.seat = seat;
    }

    // Getter for person
    public Person get_person() {
        return person;
    }

    // Setter for person
    public void set_person(Person person) {
        this.person = person;
    }

    // Method to print ticket information
    public void printTicketInfo() {
        System.out.println("Your ticket information:");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: £" + price);
        System.out.println("Person's information:");
        person.printPersonInfo();
    }

    // Method called save
    public void save() {
        String file_name=row + seat + ".txt";
        // print that details in text files
        try {
            //print ticket information
            FileWriter writer = new FileWriter(file_name);
            writer.write("Ticket information :\n");
            writer.write("Row letter: " + row + "\n");
            writer.write("Seat number: " + seat + "\n");
            writer.write("Price: " + price + "\n");

            //print person information
            writer.write("Person Information: \n");
            writer.write("Name is : " + person.getFirstName() + "\n");
            writer.write("Surname is : " + person.getSName() + "\n");
            writer.write("Email is : " + person.getEmail() + "\n");
            writer.close();
            System.out.println("Ticket information is in; " + file_name);
        }catch(IOException e){
            e.printStackTrace();

        }
    }
}