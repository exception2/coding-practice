package gfg;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovesOfKnight {
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
//        System.out.println(KnightPos[0] + " " + KnightPos[1] + " " + TargetPos[0] + " " + TargetPos[1] + " " + N);
        if(KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) return 0;
        int[][] directions = {{-1,2}, {1,2}, {2,1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{KnightPos[0], KnightPos[1], 0});
        boolean[][] vis = new boolean[N+1][N+1];
        vis[KnightPos[0]][KnightPos[1]] = true;
        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0], y = position[1], distance = position[2];
            if(x == TargetPos[0] && y == TargetPos[1]) {
                return distance;
            }
            for(int i = 0 ;i < 8; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if(nx > 0 && nx <= N && ny > 0 && ny <= N && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        MinimumMovesOfKnight mmok = new MinimumMovesOfKnight();
        System.out.println(mmok.minStepToReachTarget(new int[]{4,5}, new int[]{1,1}, 6));
    }
}
