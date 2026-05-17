import java.util.Scanner;

public class q_6 {
    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);
        System.out.print("Enter your first number : ");
        float num1 = obj.nextFloat();
        System.out.print("Enter your second number : ");
        float num2 = obj.nextFloat();
        System.out.print("select the operator (+, -, *, /) : ");
        char user_ope = obj.next().charAt(0);

        if (user_ope == '+'){
            float sum = num1+num2;
            System.out.print("Total : "+ sum);
        }
        if (user_ope == '-'){
            float sub = num1-num2;
            System.out.print("Subtraction is : "+ sub);
        }
        if (user_ope == '*'){
            float multi = num1*num2;
            System.out.print("Multiplication is : "+ multi);
        }
        if (user_ope == '/') {
            float di = num1 / num2;
            System.out.print("Division is : " + di);
        }
    }
}

