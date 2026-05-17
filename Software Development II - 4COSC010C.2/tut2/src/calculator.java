import java.util.Scanner;
public class calculator {
    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your first number : ");
        float num1 = obj.nextFloat();
        System.out.println("Enter your second number :  ");
        float num2 = obj.nextFloat();
        System.out.println("select the operator (+, -, *, /) : ");
        char user_ope = obj.next().charAt(0);

        if (user_ope == '+'){
            float sum = num1+num2;
            System.out.println("Total : "+ sum);
        }
        if (user_ope == '-'){
            float sub = num1-num2;
            System.out.println("Subtraction is : "+ sub);
        }
        if (user_ope == '*'){
            float multi = num1*num2;
            System.out.println("Multiplication is : "+ multi);
        }
        if (user_ope == '/'){
            float di = num1/num2;
            System.out.println("Division is : "+ di);
        }
    }
}
