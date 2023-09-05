package Leetcode.easy;

public class Palindrome {
        public boolean isPalindrome(int x) {
//        int xP = 0;
//        int xD = x;
//        while (xD > 0) {
//            int R = xD % 10;
//            xP = xP * 10 + R;
//            xD = xD / 10;
//        }
//
//        if (x == xP) return true;
//        return false;
        String str = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(str);

        return stringBuilder.reverse().toString().equals(str);

    }
}
