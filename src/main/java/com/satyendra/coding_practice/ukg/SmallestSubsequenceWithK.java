package ukg;

import java.util.Stack;
import java.util.stream.Collectors;

public class SmallestSubsequenceWithK {
    public static void main(String[] args) {
        System.out.println(findSmallestSubsequenceWithKLength("leetcode", 4));
    }

    private static String findSmallestSubsequenceWithKLength(String str, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++) {
            if(stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                while (!stack.isEmpty() && str.charAt(i) < stack.peek() && str.length() - i + stack.size() - 1 >= k) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.size() < k) {
                    stack.push(str.charAt(i));
                }
            }
        }
//        return stack.toString();
        return stack.stream().map(ch -> ch.toString()).collect(Collectors.joining());
    }
}
