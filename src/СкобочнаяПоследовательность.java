import java.io.IOException;
import java.util.Stack;

public class СкобочнаяПоследовательность {

    public static void main(String[] args) throws IOException {


        Stack<Character> stack = new Stack<>();
        String s = "({[]})";
        for (char currentChar : s.toCharArray()) {
            switch (currentChar) {
                case '(', '{', '[' -> stack.push(currentChar);
                case ')', '}', ']' -> {
                    if(stack.isEmpty()) {
                        System.out.println("Неверная последовательность");
                        return;
                    }
                    char charOpen = stack.pop();
                    if(charOpen == '(' && charOpen != (char)(currentChar - 1) ) {
                        System.out.println("Неверная последовательность");
                        return;
                    }
                    if(charOpen != '(' && charOpen != (char) (currentChar - 2)) {
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
