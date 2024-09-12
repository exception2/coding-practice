package general;

import java.util.LinkedList;
import java.util.Queue;

public class NearestGate {

    public static void main(String[] args) {
       /* int[][] mat = {{, "-1", "0", "INF"},
                {INF  INF  INF  -1}
                {"INF","INF", "INF"  -1}
                {"0", "INF", "INF", "INF"}};

        updateNearestGate(mat);*/
    }

    private static void updateNearestGate(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i <m;i++) {
            for(int j = 0 ; j < n ; j++) {
                if(mat[i][j] == 0) {
                    boolean[][] vis = new boolean[m][n];
                    queue.add(new int[]{i, j, 0});
                    bfs(queue, mat, vis);
                }
            }
        }
        for(int i =0 ; i < m ; i++) {
            for(int j = 0 ; j < n; j++) {
                System.out.println(mat[i][j]);
            }
        }
    }

    private static void bfs(Queue<int[]> queue, int[][] mat, boolean[][] vis) {
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for(int i =0 ; i < 4; i++) {
                int xx = arr[0] + dir[i][0];
                int yy = arr[1] + dir[i][1];
                int distance = arr[2] + 1;
                if(xx < mat.length && xx >=0 && yy >=0 && yy < mat[0].length && !vis[xx][yy] && distance < mat[xx][yy]) {
                    mat[xx][yy] = distance;
                    vis[xx][yy] = true;
                    queue.add(new int[]{xx, yy, distance});
                }
            }
        }
    }
}
