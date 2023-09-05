package TrenTestTinkoff;

import java.util.Scanner;

public class СамыйДорогойПистолет {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] <= s && array[i] > result) {
                result = array[i];
            }
        }

        System.out.println(result);
    }
}
