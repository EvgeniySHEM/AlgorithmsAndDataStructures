package TrenTestTinkoff;

import java.util.*;

public class ОграблениеБанка {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = m - 1; i >= 0; i--) {
            while (n >= array[i]) {
                if (!map.containsKey(array[i]) || map.get(array[i]) < 2) {
                    n -= array[i];
                    map.merge(array[i], 1, Integer::sum);
                    list.add(array[i]);
                } else {
                    break;
                }
            }
        }

        if (n == 0) {
            System.out.println(list.size());
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}
