import java.util.Scanner;
public class age {
    public static void main(String [] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your age : ");
        int age = obj.nextInt();
        if (age<=0){
            System.out.println("The age entered is incorrect.");}
        else if (age>=18){
            System.out.println("Over 18");
        }
        else{
            System.out.println("Under 18");
            }
        }
    }

