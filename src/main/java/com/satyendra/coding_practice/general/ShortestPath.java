package general;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int dx[][] = {{1,0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0,1}, {1,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int level = 0;
        while(!q.isEmpty()) {
            level++;
            int qSize = q.size();
            while(qSize-- != 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                //reached the end
                if(x == n - 1 && y == n - 1) {
                    return level;
                }
                for(int i = 0; i < 8; i++) {
                    int nx = x + dx[i][0];
                    int ny = y + dx[i][1];
                    if(isValidMove(nx, ny, n, grid)) {
                        q.add(new int[]{nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValidMove(int nx, int ny, int n, int[][] grid) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0;
    }
}
