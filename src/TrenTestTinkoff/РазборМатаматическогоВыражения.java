package TrenTestTinkoff;

import java.util.Scanner;
import java.util.Stack;

public class РазборМатаматическогоВыражения {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        expression = expression.substring(0, expression.length() - 1); // убираем точку в конце выражения
        try {
            long result = evaluate(expression);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("WRONG");
        }
    }

    // метод для вычисления значения выражения
    private static long evaluate(String expression) throws Exception {
        Stack<Long> numbers = new Stack<>(); // стек для хранения чисел
        Stack<Character> operators = new Stack<>(); // стек для хранения операторов
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) { // если текущий символ - цифра, считываем число
                long num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                numbers.push(num);
            } else if (c == '(') { // если текущий символ - открывающая скобка, рекурсивно вычисляем выражение внутри скобок
                int j = i + 1;
                int balance = 1;
                while (j < expression.length() && balance > 0) {
                    if (expression.charAt(j) == '(') {
                        balance++;
                    } else if (expression.charAt(j) == ')') {
                        balance--;
                    }
                    j++;
                }
                if (balance != 0) { // если скобки не сбалансированы, выражение некорректно
                    throw new Exception();
                }
                long num = evaluate(expression.substring(i + 1, j - 1));
                numbers.push(num);
                i = j;
            } else if (c == '+' || c == '-' || c == '*') { // если текущий символ - оператор
                if (operators.isEmpty() || priority(c) > priority(operators.peek())) {
                    operators.push(c);
                    i++;
                } else {
                    long num2 = numbers.pop();
                    long num1 = numbers.pop();
                    char op = operators.pop();
                    long result = applyOp(num1, num2, op);
                    numbers.push(result);
                }
            } else { // если текущий символ - что-то другое, выражение некорректно
                throw new Exception();
            }
        }
        while (!operators.isEmpty()) { // вычисляем оставшиеся операции
            long num2 = numbers.pop();
            long num1 = numbers.pop();
            char op = operators.pop();
            long result = applyOp(num1, num2, op);
            numbers.push(result);
        }
        return numbers.pop(); // возвращаем результат
    }

    // метод для определения приоритета оператора
    private static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*') {
            return 2;
        } else {
            return 0;
        }
    }

    // метод для применения оператора к двум числам
    private static long applyOp(long num1, long num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}
