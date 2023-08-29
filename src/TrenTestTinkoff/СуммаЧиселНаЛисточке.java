package TrenTestTinkoff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class СуммаЧиселНаЛисточке {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Long> values = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int t = scanner.nextInt();
            int weight = 1;
            while (t > 0) {
                int digit = t % 10;
                long gain = (long) (9 - digit) * weight;
                values.add(gain);
                weight *= 10;
                t /= 10;
            }
        }

        long sum = values.stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .reduce(0l, Long::sum);

        System.out.println(sum);
    }
}
