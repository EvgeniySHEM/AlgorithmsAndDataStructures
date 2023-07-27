import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static Map<Integer, BigInteger> cash = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(fibEffective(5));
//        System.out.println(recFib(45));
        System.out.println(recFibWithCash(300));
        System.out.println(fibLite(6));

    }

    /**
     * Итеративно
     */
    private static BigInteger fibLite(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;
        for(int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * Итеративно с использованием доп массива
     */
    private static BigInteger fibEffective(int n) {
        BigInteger[] array = new BigInteger[n + 1];

        array[0] = BigInteger.valueOf(0);
        array[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1].add(array[i - 2]);
        }

        return array[n];
    }

    /**
     * рекурсивно
     */
    private static int recFib(int i) {
        if (i < 2) {
            return i;
        }
        return recFib(i - 1) + recFib(i - 2);
    }

    /**
     * рекурсивно c кешем
     */

    private static BigInteger recFibWithCash(int i) {
        if (i < 2) {
            return BigInteger.valueOf(i);
        }

        if (cash.containsKey(i)) {
            return cash.get(i);
        } else {
            BigInteger res = recFibWithCash(i - 1).add(recFibWithCash(i - 2));
            cash.put(i, res);
            return res;
        }
    }
}
