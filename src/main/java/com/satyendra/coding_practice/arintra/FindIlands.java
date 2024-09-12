package arintra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindIlands {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
            };

        System.out.println(findComponents(grid));
    }
    static int findComponents(int[][] grid) {
        int m = grid.length;
        if(m==0) {
            return 0;
        }
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int coord[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //Arrays.fill(vis, false);
        int count = 0;
        for(int i =0 ; i < m; i++) {
            for (int j = 0; j < n;j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    findCount(grid, vis, i, j, coord, m, n);
                }
            }
        }
        return count;
    }
    static void findCount(int[][] grid, boolean[][] vis, int row, int col, int[][] c, int m, int n) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(row, col));
        while (!queue.isEmpty()) {

            Cell cell= queue.poll();
            int x = cell.x;
            int y = cell.y;
            vis[x][y] = true;
            for(int i =0 ; i < 4;i++) {
                int xx = x + c[i][0];
                int yy = y + c[i][1];
                if(xx >=0 && xx < m && yy >=0 && yy < n && grid[xx][yy] == 1 && !vis[xx][yy]) {
                    queue.add(new Cell(xx, yy));
                }
            }
        }
    }
    static class Cell {
        int x, y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
