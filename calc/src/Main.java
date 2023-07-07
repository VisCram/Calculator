import java.util.Scanner;

public class Main {
    public static String exp;
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
         exp = scn.nextLine();
        Calc.calc(exp);
    }
}
