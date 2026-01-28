import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private int row; // Row number of the seat
    private int seat; // Seat number
    private int price; // Price of the ticket
    private Person person; // Person who bought the ticket

    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters and setters
    public int getRow() { return row; }
    public int getSeat() { return seat; }
    public int getPrice() { return price; }
    public Person getPerson() { return person; }


    public String toString() {
        return "Row " + (row + 1) + ", Seat " + (seat + 1) + ", Price £" + price + ", " + person;
    }
}

//public void save() {
//    String file_name=row + seat + ".txt";
//    // print that details in text files
//    try {
//        //print ticket information
//        FileWriter writer = new FileWriter(file_name);
//        writer.write("Ticket information :\n");
//        writer.write("Row letter: " + row + "\n");
//        writer.write("Seat number: " + seat + "\n");
//        writer.write("Price: " + price + "\n");
//
//        //print person information
//        writer.write("Person Information: \n");
//        writer.write("Name is : " + person.getFirstName() + "\n");
//        writer.write("Surname is : " + person.getSName() + "\n");
//        writer.write("Email is : " + person.getEmail() + "\n");
//        writer.close();
//        System.out.println("Ticket information is in; " + file_name);
//    }catch(IOException e){
//        e.printStackTrace();
//
//    }
//}
