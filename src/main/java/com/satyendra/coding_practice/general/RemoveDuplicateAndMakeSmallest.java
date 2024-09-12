package general;

import java.util.Stack;

public class RemoveDuplicateAndMakeSmallest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution.removeDuplicateLetters("leetcode"));
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) count[c]++;
        for(int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch]--;
            if(stack.contains(ch)) continue;
            while(!stack.isEmpty() && ch < stack.peek() && count[stack.peek()] > 0) {
                stack.pop();
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);
        return sb.toString();
    }
}
