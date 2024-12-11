package com.satyendra.coding_practice.phonepe;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        System.out.println(longestPalindromeSubstring.findSubstring("geeksforgeeks"));
        System.out.println(longestPalindromeSubstring.findSubstring("forgeeksskeegfor"));
        System.out.println(longestPalindromeSubstring.findSubstring("abc"));
        System.out.println(longestPalindromeSubstring.findSubstring(""));
    }

    private String findSubstring(String str) {
        int n = str.length();

        if(n == 0) {
            return str;
        }
        int res = 0;
        int start = 0;
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            dp[i][i] = 1;
        }
        res = 1;
        for(int i = 0 ; i < n-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) {
                dp[i][i+1] = 2;
                start = i;
            }
        }
        res = 2;
        for(int size = 3; size <= n ; size++) {
            for(int i = 0 ; i <= n - size; i++) {
                int j = i + size - 1;
                if(dp[i+1][j-1] != 0 && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = size;
                    if(res < size) {
                        res = size;
                        start = i;
                    }
                }
            }
        }
        return str.substring(start, start + res);
    }
}
