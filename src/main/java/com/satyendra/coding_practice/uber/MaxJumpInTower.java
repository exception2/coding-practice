package com.satyendra.coding_practice.uber;

import java.util.Arrays;

public class MaxJumpInTower {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {60, 60, 40},
                {50, 40, 45},
                {15, 10, 10}
        };

        MaxJumpInTower maxJumpInTower = new MaxJumpInTower();
        System.out.println(maxJumpInTower.findMaxJump(matrix));
    }

    private int findMaxJump(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result = Math.max(dfs(matrix, dp, i, j), result);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int[][] dp, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        int maxJumps = 1;
        for(int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if(nx >=0 && nx < n && ny >= 0 && ny < m && matrix[x][y] < matrix[nx][ny]) {
                maxJumps = Math.max(maxJumps, 1 + dfs(matrix, dp, nx, ny));
            }
        }

        dp[x][y] = maxJumps;
        return dp[x][y];
    }
}
