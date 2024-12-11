package com.satyendra.coding_practice.uber;

import java.util.Arrays;

public class MaxJump {

    int[][] direction = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public static void main(String[] args) {
        MaxJump maxJump = new MaxJump();
        int[][] matrix1 = new int[][]{
                {60, 60, 40},
                {50, 40, 45},
                {15, 10, 10}
        };
        System.out.println(maxJump.findMaxJump(matrix1));
    }

    private int findMaxJump(int[][] matrix) {
        int res = Integer.MIN_VALUE, n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                res = Math.max(res, bfs(matrix, i, j,n,m, dp));
            }
        }
        return res;
    }

    private int bfs(int[][] matrix, int i, int j, int n, int m, int[][] dp) {

        if(i < 0 || j < 0 || i >=n || j >= m) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 1;
        for(int d = 0 ; d < n ; d++) {
            int x = i + direction[d][0];
            int y = j + direction[d][1];

            if(x>=0 && y>=0 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                ans = 1 + bfs(matrix, x, y, n, m, dp);
            }
        }
        return dp[i][j] = ans;
    }
}
