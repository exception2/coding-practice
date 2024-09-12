package general;

public class LargestIceland {

    public static void main(String[] args) {
        LargestIceland li = new LargestIceland();
        System.out.println(li.maxAreaOfIsland(new int[][] {{0,1,0}, {0,1,0}, {1,1,0}}));
    }

    private int maxAreaOfIsland(int[][] lands) {
        int largestIceland = 0;
        int m = lands.length;
        int n = lands[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m ;i++) {
            for(int j = 0; j<n;j++) {
                if(!vis[i][j] && lands[i][j] == 1) {
                    largestIceland = Math.max(largestIceland, findLand(lands, vis, i, j));
                }
            }
        }
        return largestIceland;
    }

    private int findLand(int[][] lands, boolean[][] vis, int x,int y) {
        int[][] coordinates = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        vis[x][y] = true;
        int count = 1;
        for(int i =0 ;i < 4;i++) {
            int xx = x+coordinates[i][0], yy = y+coordinates[i][1];
            if(xx >=0 && xx < lands.length && yy >=0 && yy <lands[0].length && !vis[xx][yy] && lands[xx][yy] == 1) {
                count += findLand(lands, vis, xx, yy);
            }
        }
        return count;
    }
}
