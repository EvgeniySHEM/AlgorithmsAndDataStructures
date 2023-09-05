package TrenTestTinkoff;

import java.util.Arrays;
import java.util.Scanner;

public class ВыигрышнаяПоследовательностьКарт {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrayJo = new int[n];

        for (int i = 0; i < n; i++) {
            arrayJo[i] = scanner.nextInt();
        }

        int[] arrayWin = new int[n];
        for (int i = 0; i < n; i++) {
            arrayWin[i] = scanner.nextInt();
        }

        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (left == right) {
                if (arrayJo[left] == arrayWin[left]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                return;
            }

            if (arrayJo[left] == arrayWin[left]) {
                left++;
            }

            if (arrayJo[right] == arrayWin[right]) {
                right--;
            }
        }
        Arrays.sort(arrayJo, left, right + 1);

        if (Arrays.equals(arrayJo, arrayWin)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
