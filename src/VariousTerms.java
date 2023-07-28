import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VariousTerms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
//        variousTerms(a);
        variousTerms2(a);
    }

    private static void variousTerms2(long n) {
        long i = 1;

        StringBuilder sb = new StringBuilder();

        while ( n > 2 * i ) {
            n -= i;
            sb.append(i++).append(" ");
        }

        sb.append(n);
        System.out.println(i);
        System.out.println(sb.toString());
    }

    private static void variousTerms(long n) {
        int count = 0;
        long sum = 0;
        List<Long> res = new ArrayList<>();
        if (n < 3) {
            res.add(n);
            count++;
        }
        for (long i = 1; i < n; i++) {
            if(sum > 0 && sum + i == n) {
                res.add(i);
                count++;
            }

            if(n - (sum + i) < i) {
                continue;
            }

            if(n - (sum + i) > i) {
                res.add(i);
                sum += i;
                count++;
            }
        }
        System.out.println(count);
        res.forEach(el -> System.out.print(el + " "));

    }
}
