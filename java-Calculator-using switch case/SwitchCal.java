import java.util.Scanner;
public class SwitchCal {
    public static void main(String[] args) {
        double c,b,tot;

        System.out.println("Enter First Number");
        Scanner no1 = new Scanner(System.in);
        c= no1.nextDouble();

        System.out.println("Enter Second Number");
        Scanner no2 = new Scanner(System.in);
        b= no2.nextDouble();

        System.out.println("Enter an Arithmetic Operator like '+ ,- ,* ,/' ");
        Scanner in = new Scanner(System.in);
        String a=in.nextLine();


        switch (a){
            case "+":
                tot=c+b;
                System.out.println(+c+" + "+b+" = "+tot);
                break;
            case "-":
                tot=c-b;
                System.out.println(+c+" - "+b+" = "+tot);
                break;
            case "*":
                tot=c*b;
                System.out.println(+c+" * "+b+" = "+tot);
                break;
            case "/":
                tot=c/b;
                System.out.println(+c+" / "+b+" = "+tot);
                break;
        }
    }
}
