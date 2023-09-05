package TrenTestTinkoff;

import java.util.Scanner;

public class СоставитьСлово {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] charArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'a']++;
        }
        int maxWords = Integer.MAX_VALUE;
        String target = "sheriff";
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            maxWords = Math.min(maxWords, charArray[c - 'a']);
        }
        while (maxWords * 2 > charArray['f' - 'a'] && maxWords > 0) {
            maxWords--;
        }

        System.out.println(maxWords);
    }
}
