import java.util.Scanner;
public class q_1 {
    public static void main(String [] args){

        int [] numbers = {1,2,3,4,5,6};
        System.out.println(numbers);

        int[] marks = new int [6];
        Scanner obj = new Scanner (System.in);

        for (int i= 0 ; i<=marks.length-1 ; i++){
            System.out.print("Enter your marks : ");
            marks[i] = obj.nextInt();
        }
    }
}

