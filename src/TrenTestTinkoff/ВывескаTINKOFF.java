package TrenTestTinkoff;

import java.util.Scanner;

public class ВывескаTINKOFF {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            int counter = 0;
            String letters = scanner.nextLine();
            int[] counts = new int[26];

            for (char c : letters.toCharArray()) {
                counts[c - 'A']++;
                counter++;
            }

            boolean canSpell = true;
            String target = "TINKOFF";

            for (char c : target.toCharArray()) {
                if (counts[c - 'A'] == 0) {
                    canSpell = false;
                    break;
                } else {
                    counts[c - 'A']--;
                    counter--;
                }
            }

            if(counter == 0 && canSpell) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
