import java.util.Scanner;

public class moduleMarkCalculation
{
    public static void main(String [] args)
    {
        int fmarks = 0;

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your In Class Test (ICT) marks : ");
        int ictm = obj.nextInt();

        if (ictm < 30)
        {
            System.out.println("You fail the In Class Test (ICT)");
        }
        else
        {
            System.out.println("You pass the In Class Test (ICT)");
        }
        System.out.println("enter your Coursework (CW) marks : ");
        int cwm = obj.nextInt();
        if (cwm < 30)
        {
            System.out.println("You fail the coursework");
        }
        else
        {
            System.out.println("You pass the coursework");
        }
        fmarks = (ictm + cwm)/2;
        if (fmarks>40)
        {
            System.out.println("Your final marks : " + fmarks);
            System.out.println("You pass the module");
        }
        else
        {
            System.out.println("Your final marks : " + fmarks);
            System.out.println("You fail the module");
        }
    }
}
