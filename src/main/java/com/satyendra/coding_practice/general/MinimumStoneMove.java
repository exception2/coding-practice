package general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumStoneMove {


    public static void main(String[] args) {
        System.out.println(new MinimumStoneMove().minimumMoves1(new int[][]{{3,2,0},{0,1,0},{0,3,0}}));
    }
    public int minimumMoves1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] > 1) {
                    ans += fill(grid, i, j, grid[i][j] - 1);
                }
            }
        }
        return ans;
    }

    private int fill(int[][] grid, int i, int j, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int level = 0;
        int move = 0;
        while (!queue.isEmpty() && n > 0) {
            int size = queue.size();
            level++;
            while(size-- != 0 && n > 0) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] direction : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                        if(grid[nx][ny] == 0 && n > 0) {
                            grid[nx][ny] = 1;
                            n--;
                            move += level;
                        }
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return move;
    }
    public int minimumMoves(int[][] grid) {
        List<int[]> extra = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++) {
            for( int j = 0 ; j < m ; j++) {
                if(grid[i][j]==0) {
                    list.add(new int[]{i, j});
                }
                if(grid[i][j] > 1) {
                    extra.add(new int[]{i, j, grid[i][j] - 1});
                }
            }
        }
        int move =0 ;
        for(int[] arr : list) {
            // find shortest distance
            int index = -1;
            int minimumDist = Integer.MAX_VALUE;
            for(int i = 0 ; i<extra.size(); i++) {
                int[] cell = extra.get(i);
                if(cell[2] <= 0) continue;
                int dist = Math.abs(arr[0] - cell[0]) + Math.abs(arr[1] - cell[1]);
                if(dist < minimumDist) {
                    index = i;
                    minimumDist = dist;
                }
            }
            move += minimumDist;
            int[] arr1 = extra.get(index);
            arr1[2]--;
            extra.set(index, arr1);
        }
        return move;
    }
}

