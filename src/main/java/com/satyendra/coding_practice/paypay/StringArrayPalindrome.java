package com.satyendra.coding_practice.paypay;

public class StringArrayPalindrome {
    public static void main(String[] args) {
        StringArrayPalindrome obj = new StringArrayPalindrome();
        System.out.println(obj.isPalindrome(new String[]{"abc", "def", "abc"}));
        System.out.println(obj.isPalindrome(new String[]{"aa", "bab", "cde", "aba", "ab"}));
    }

    private boolean isPalindrome(String[] strings) {
        int left = 0, right = strings.length - 1;
        while(left < right) {
            if(!strings[left].equals(strings[right])) {
                int leftLen = strings[left].length();
                int rightLen = strings[right].length();
                if(Math.abs(leftLen - rightLen) > 2) {
                    return false;
                }
                String leftStr = strings[left];
                String rightStr = strings[right];
                leftStr = leftStr + strings[left + 1].charAt(0);
                if(leftStr.equals(rightStr)) {
                    updateStrings(strings, left, "LEFT");
                } else {
                    rightStr = strings[right - 1].charAt(strings[right - 1].length() - 1) + rightStr;
                }
                if(leftStr.equals(rightStr)) {
                    updateStrings(strings, right, "RIGHT");
                } else {
                    leftStr = strings[left];
                }
                if(leftStr.equals(rightStr)) {
                    updateStrings(strings, left, "LEFT");
                    updateStrings(strings, right, "RIGHT");
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    private void updateStrings(String[] strings, int index, String ops) {
        if (ops.equals("LEFT")) {
            strings[index] = strings[index] + strings[index + 1].charAt(0);
            strings[index+1] = strings[index + 1].substring(1);
        } else if (ops.equals("RIGHT")) {
            strings[index] = strings[index - 1].charAt(strings[index - 1].length() - 1) + strings[index];
            strings[index - 1] = strings[index - 1].substring(0, strings[index - 1].length() - 1);
        }
    }
}
