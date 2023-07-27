import java.util.Scanner;

/**
 * наибольший общий делитель
 */

public class GreatestCommonDivisor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(greatestCommonDivisor(scanner.nextInt(), scanner.nextInt()));

    }

    private static int greatestCommonDivisor(int a, int b) {
        if (a == 0)
            return b;

        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return greatestCommonDivisor(a % b, b);
        else
            return greatestCommonDivisor(a, b % a);
    }
}
