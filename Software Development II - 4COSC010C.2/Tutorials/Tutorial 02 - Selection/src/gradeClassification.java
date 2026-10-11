import java.util.Scanner;

public class gradeClassification {
    public static void main (String [] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your score : ");
        int marks = obj.nextInt();

        if (marks >=100){
            System.out.println("Invalid value");
        }
        else if (marks >=70){
            System.out.println("1st Class Honours (1)");
        }
        else if (marks >=69){
            System.out.println("2nd Class Honours Upper Division (2:i)");
        }
        else if (marks >=59){
            System.out.println("2nd Class Honours Lower Division (2:ii)");
        }
        else if (marks >=40){
            System.out.println("3rd Class Honours (3)");
        }
        else {
            System.out.println("Invalid value");
        }
    }
}
