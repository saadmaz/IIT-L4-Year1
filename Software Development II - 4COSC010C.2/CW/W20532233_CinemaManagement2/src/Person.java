public class Person {
    private String name; // User's name
    private String surname; // User's surname
    private String email; // User's email

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Getters and setters
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getEmail() { return email; }


    public String toString() {
        return name + " " + surname + " (" + email + ")"; // String representation of Person object
    }
}
