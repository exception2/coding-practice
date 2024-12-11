package com.satyendra.coding_practice.wayfair;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/discuss/interview-question/algorithms/4418282/WayFair-Hackerrank-or-SSE-or-Dec-2023/
public class HackerManJump {
    public static void main(String[] args) {
        int[][] maze1 = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };
        int k = 2;
        System.out.println(minimumJumpNeed(maze1, k));

        int[][] maze2 = new int[][]{
                {0, 0},
                {1, 0}
        };
        k = 2;
        System.out.println(minimumJumpNeed(maze2, k));

        int[][] maze3 = new int[][]{
                {0, 0, 0},
                {1, 0, 0}
        };
        k = 5;
        System.out.println(minimumJumpNeed(maze3, k));

        int[][] maze4 = new int[][]{
                {0, 1, 0},
                {1, 0, 0}
        };
        k = 5;
        System.out.println(minimumJumpNeed(maze4, k));
    }

    private static int minimumJumpNeed(int[][] maze, int k) {
        int n = maze.length;
        int m = maze[0].length;
        if (k <= 0 || maze[0][0] == 1 || maze[n - 1][m - 1] == 1) {
            return -1;
        }

        // Define the four possible directions with multiple steps based on k.
        int[][] directions = new int[4 * k][2];
        for (int i = 1; i <= k; i++) {
            directions[i - 1] = new int[]{i, 0};      // Right i steps
            directions[i + k - 1] = new int[]{-i, 0}; // Left i steps
            directions[i + 2 * k - 1] = new int[]{0, i}; // Down i steps
            directions[i + 3 * k - 1] = new int[]{0, -i}; // Up i steps
        }

        Queue<Node> queue = new LinkedList<>();
        // Start at (0,0) with level 0.
        queue.add(new Node(0, 0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node cell = queue.poll();
            int x = cell.x;
            int y = cell.y;

            // Target cell reached
            if (x == n - 1 && y == m - 1) {
                return cell.level;
            }

            // Explore all 4 directions with varying steps (from 1 to k)
            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 0 && noObs(maze, x, y, nx, ny) && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, cell.level + 1));
                    visited[nx][ny] = true; // Mark as visited
                }
            }
        }
        return -1;
    }

    // Helper method to check if there is no obstacle in the direct path from (x, y) to (nx, ny)
    private static boolean noObs(int[][] maze, int x, int y, int nx, int ny) {
        if (x == nx) { // Horizontal move
            if (y < ny) { // Move right
                for (int i = y + 1; i < ny; i++) {
                    if (maze[x][i] == 1) return false;
                }
            } else { // Move left
                for (int i = ny + 1; i < y; i++) {
                    if (maze[x][i] == 1) return false;
                }
            }
        } else { // Vertical move
            if (x < nx) { // Move down
                for (int i = x + 1; i < nx; i++) {
                    if (maze[i][y] == 1) return false;
                }
            } else { // Move up
                for (int i = nx + 1; i < x; i++) {
                    if (maze[i][y] == 1) return false;
                }
            }
        }
        return true;
    }

    // Node class to store the position (x, y) and the current level (jumps taken)
    static class Node {
        int x, y, level;

        Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}
