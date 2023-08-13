import java.io.IOException;
import java.util.Stack;

public class СкобочнаяПоследовательность {

    public static void main(String[] args) throws IOException {

        Stack<Character> stack = new Stack<>();
        String s = "({[]})";
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(', '{', '[' -> stack.push(s.charAt(i));
                case ')', '}', ']' -> {
                    if(stack.isEmpty()) {
                        System.out.println("Неверная последовательность");
                        return;
                    }
                    char charOpen = stack.pop();
                    char charClosed = s.charAt(i);
                    if(charOpen == '(' && charOpen != (char)(charClosed - 1) ) {
                        System.out.println("Неверная последовательность");
                        return;
                    }
                    if(charOpen != '(' && charOpen != (char) (charClosed - 2)) {
                        System.out.println("Неверная последовательность");
                        return;
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("Последовательность верная");
        } else {
            System.out.println("Неверная последовательность");
        }
    }
}
