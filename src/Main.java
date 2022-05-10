import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello, we can help you calculate your salary");
        Scanner sc= new Scanner(System.in);
        System.out.print("bruto alga ");
        double brutoAlga = sc.nextDouble();
        System.out.print("apgādājamo skaits ");
        double apgSk = sc.nextDouble();
        apgSk = apgSk * 250;
        System.out.print("atvieglojums par invalidāti ");
        double atvieglojumsInv = sc.nextDouble();
        System.out.print("neapliekamais minimums ");
        double neapliekamaisMin = sc.nextDouble();
        double neto =0;
        System.out.print("nodoklu gramata ");
        boolean ndGr = sc.nextBoolean();
        if (NG = true) {
            if (brutoAlga <= 1667) {
                neto = brutoAlga - (brutoAlga * 0.105) - ((1667 - (brutoAlga * 0.105) - apgSk - neapliekamaisMin - atvieglojumsInv) * 0.2 + (brutoAlga - 1667) * 0.2);
            } else {
                neto = brutoAlga - (brutoAlga * 0.105) - ((1667 - (brutoAlga * 0.105) - apgSk - neapliekamaisMin - atvieglojumsInv) * 0.2 + (brutoAlga - 1667) * 0.23);
            }
        }
        else {
            neto = brutoAlga*0.23-(brutoAlga*0.105)*0.20;
        }

            System.out.println(neto);

    }
}