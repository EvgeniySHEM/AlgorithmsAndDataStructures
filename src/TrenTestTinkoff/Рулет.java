package TrenTestTinkoff;

import java.util.Scanner;

public class Рулет {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result = 0;
        long p = 1L;
        while (p < a) {
            result += 1;
            p *= 2;
        }
        System.out.println(result);
    }
}
