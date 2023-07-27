
import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibEffective(841645));
    }

    private static long fibEffective(int n) {
        long[] array = new long[n + 1];

        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];
    }
}
