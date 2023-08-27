import java.util.Scanner;

public class МаксимальнаяСуммаНаСтупеньках {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if(n == 1) {
            System.out.println(a[0]);
            return;
        }
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.max(0, dp[0]) + a[1];

        if(n == 2) {
            System.out.println(dp[1]);
            return;
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]) + a[i];
        }
        System.out.println(dp[n-1]);
    }
}
