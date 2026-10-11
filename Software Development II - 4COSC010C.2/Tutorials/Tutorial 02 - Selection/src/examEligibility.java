import java.util.Scanner;

public class examEligibility {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Number of classes held : ");
        float no_clz_held = obj.nextInt();
        System.out.println("Number of classes attended : ");
        float no_clz_att = obj.nextInt();
        System.out.println("If you have medical cause or not (Y/N) : ");
        char medical = obj.next().charAt(0);

        float attendance = (no_clz_att / no_clz_held) * 100;
        if (attendance > 75 || medical == 'Y') {
            System.out.println("You are allow to sit in exam");
            System.out.println("Your attendance : " + attendance + '%');
        }
        else if(attendance > 75 || medical == 'N') {
            System.out.println("You are not allow to sit in exam");
            System.out.println("Your attendance : " + attendance + '%');
        }
    }
}
