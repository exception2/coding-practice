package wayfair;

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
    }

    private static int minimumJumpNeed(int[][] maze, int k) {
        int n = maze.length;
        int m = maze[0].length;
        if(maze[0][0] == 1 || maze[n-1][m-1] == 1) {
            return -1;
        }
        int[][] directions = new int[4*k][2];
        for(int i = 1; i <= k; i++) {
            directions[i-1] = new int[]{i, 0};
            directions[i+k-1] = new int[]{-i, 0};
            directions[i+2*k-1] = new int[]{0, i};
            directions[i+3*k-1] = new int[]{0, -i};
        }
        Queue<Node> queue = new LinkedList<>();
        // start cell
        queue.add(new Node(0,0, 0));
        while (!queue.isEmpty()) {
            Node cell = queue.poll();
            int x = cell.x;
            int y = cell.y;
            // target cell reached
            if (x == n - 1 && y == m - 1) {
                return cell.level;
            }
            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 0) {
                    queue.add(new Node(nx, ny, cell.level + 1));
                    maze[nx][ny] = 1;
                }
            }
        }
        return -1;
    }

    static class Node {
        int x,y,level;
        Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    // Time complexity: O(n*m*k)
}
