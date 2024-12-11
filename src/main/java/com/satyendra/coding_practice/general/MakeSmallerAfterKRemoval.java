package com.satyendra.coding_practice.general;

import java.util.Stack;

public class MakeSmallerAfterKRemoval {
    public static void main(String[] args) {
        MakeSmallerAfterKRemoval makeSmallerAfterKRemoval = new MakeSmallerAfterKRemoval();
        System.out.println(makeSmallerAfterKRemoval.removeKdigits("1432219", 3));
        System.out.println(makeSmallerAfterKRemoval.removeKdigits("10200", 1));
        System.out.println(makeSmallerAfterKRemoval.removeKdigits("10", 2));
        System.out.println(makeSmallerAfterKRemoval.removeKdigits("12345", 2));
    }

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(i) < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        String s = removeLeadingZero(res.reverse().toString());
        return s.isEmpty() ? "0" : s;
    }

    private String removeLeadingZero(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
