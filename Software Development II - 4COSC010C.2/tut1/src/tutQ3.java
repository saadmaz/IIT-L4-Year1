import java.util.*;

public class tutQ3 {
    public static void main (String [] args){
        Scanner marks = new Scanner(System.in);
        System.out.println("Enter your maths marks : ");
        int mathsmarks = marks.nextInt();
        System.out.println("Enter your English marks : ");
        int englishmarks = marks.nextInt();
        System.out.println("Enter your Science marks : ");
        int scimarks = marks.nextInt();

        System.out.println("Your Maths marks : " + mathsmarks);
        System.out.println("Your English marks : " + englishmarks);
        System.out.println("Your Science marks : " + scimarks);
        int total = mathsmarks + englishmarks + scimarks;
        System.out.println("Total marks : " + total);
        int avg = total/3;
        System.out.println("Average : " + avg);


    }
}
