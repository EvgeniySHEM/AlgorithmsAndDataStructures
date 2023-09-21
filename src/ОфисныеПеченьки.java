import java.util.Scanner;

public class ОфисныеПеченьки {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cookies = new int[n];

        int maxCookies = 0;
        for (int i = 0; i < n; i++) {
            cookies[i] = scanner.nextInt();
            maxCookies = Math.max(maxCookies, cookies[i]);
        }
        int left = 0;
        int right = maxCookies;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canEatAll(cookies, m, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean canEatAll(int[] cookies, int m, int k) {
        long time = 0;
        for (int i = 0; i < cookies.length; i++) {
            time += (long) Math.ceil((double) cookies[i] / k);
            if (time > m) {
                return false;
            }
        }
        return true;

    }

}
