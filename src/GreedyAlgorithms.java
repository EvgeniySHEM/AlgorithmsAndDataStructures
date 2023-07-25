import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithms {
    public static void main(String[] args) {

        int[] digits = {3,1,7,9,9,5};
        System.out.println(maxNumberFromDigits1(digits));
        System.out.println(maxNumberFromDigits2(digits));
    }

    private static String maxNumberFromDigits1(int[] digits) {
        Arrays.sort(digits); //O (nlogn)
        StringBuilder result = new StringBuilder(digits.length);

        for (int i = digits.length - 1; i >= 0 ; i--) { //O(n)
            result.append(digits[i]);
        }

        return result.toString();
    }

    private static String maxNumberFromDigits2(int[] digits) {
        return String.join("", Arrays.stream(digits)
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }
}
