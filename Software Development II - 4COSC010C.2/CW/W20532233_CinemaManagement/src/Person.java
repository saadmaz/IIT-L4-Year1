public class Person {
    // Fields
    private String f_name; // first name
    private String s_name; // surname
    private String email; // Email address

    // Constructor
    public Person(String f_name, String s_name, String email) {
        this.f_name = f_name;
        this.s_name = s_name;
        this.email = email;
    }

    // Getter for first name
    public String getFirstName() {
        return f_name;
    }

    // Setter for first name
    public void setFirstName(String f_name) {
        this.f_name = f_name;
    }

    // Getter for surname
    public String getSName() {
        return s_name;
    }

    // Setter for surname
    public void setSName(String s_name) {
        this.s_name = s_name;
    }

    // Getter for email address
    public String getEmail() {
        return email;
    }

    // Setter for email address
    public void setEmail(String email) {
        this.email = email;
    }

    // Method to print user information
    public void printPersonInfo() {
        System.out.println("Name: " + f_name);
        System.out.println("Surname: " + s_name);
        System.out.println("Email: " + email);
    }
}