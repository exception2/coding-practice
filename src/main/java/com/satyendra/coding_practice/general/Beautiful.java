package general;

import java.util.Scanner;

public class Beautiful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(findMinDiffToMakeBeautiful(a, n));
        }
    }


    private static int solveUtil(int[] a, int i, int n) {
        if(i > n) {
            return Integer.MAX_VALUE;
        }
        else if(i == n) {
            return 0;
        }
        int notTake = 1 + solveUtil(a, i + 1, n);
        int take = solveUtil(a, i + a[i] + 1, n);
        return Math.min(notTake, take);
    }

    private static int findMinDiffToMakeBeautiful(int[] a, int n) {
        int[] dp = new int[n+1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];
            if(i + a[i] + 1 <= n) {
                dp[i] = Math.min(dp[i], dp[i + a[i] + 1]);
            }
        }

        return dp[0];
    }
}

