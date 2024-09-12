package general;

import java.util.Map;
import java.util.Stack;

public class Calculator2 {
    public static void main(String[] args) {
        System.out.println(calculate("1-1+1"));
    }
    public static int calculate(String s) {
        int n = s.length();
        Stack<Long> result = new Stack<>();
        Stack<Character> operators = new Stack<>();
        Map<Character, Integer> precedenceMap = Map.of(
                '-', 1,
                '+', 1,
                '*', 3,
                '/', 3
        );

        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result.push(num);
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && precedenceMap.get(operators.peek()) >= precedenceMap.get(ch)){
                    long num1 = result.pop();
                    long num2 = result.pop();
                    result.push(applyOp(operators.pop(), num1, num2));
                }
                operators.push(ch);
                i++;

            } else {
                i++;
            }
        }

        while (!operators.isEmpty()){
            long num1 = result.pop();
            long num2 = result.pop();
            result.push(applyOp(operators.pop(), num1, num2));
        }
        return result.pop().intValue();
    }

    private static Long applyOp(Character operator, long num1, long num2) {
        switch (operator) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                return 0L;
        }
    }

    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }
}
