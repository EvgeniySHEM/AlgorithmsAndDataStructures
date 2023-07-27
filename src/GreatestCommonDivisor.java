import java.util.Scanner;

/**
 * наибольший общий делитель
 */

public class GreatestCommonDivisor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();
        int s = scanner.nextInt();
        System.out.println(greatestCommonDivisor(f, s));
        System.out.println(iterGCD(f, s));
        System.out.println(gCD(f, s));

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

    /**
     * Замена хвостовой рекурсии на цикл
     * @param a
     * @param b
     * @return
     */
    private static int gCD(int a, int b) {
        while (true) {
            if (a == 0) return b;

            if (b == 0) return a;

            if (a == b) return a;

            if (a > b)
                a %= b;
            else
                b %= a;
        }

    }

    /**
     * итеративно (долго)
     */
    private static int iterGCD(int a, int b) {
        int res = 0;
        int max = Math.max(a, b);
        for (int i = 1; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                res = i;
            }
        }
        return res;
    }
}
