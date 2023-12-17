package TrenTestTinkoff;

import java.util.Scanner;

public class Социализация {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            boolean canContact = true;
            int n = scanner.nextInt();
            int counter = 2;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int sociality = scanner.nextInt();
                if(sociality == 0) {
                    canContact = false;
                    break;
                }
                if(i > 1) {
                    counter += 2;
                }
                sum += sociality;
            }

            if(canContact) {
                if(counter > sum) {
                    canContact = false;
                }
            }
            System.out.println(canContact ? "Yes" : "No");
        }
    }
}
