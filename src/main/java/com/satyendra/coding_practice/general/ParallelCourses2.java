package general;

public class ParallelCourses2 {
    public static void main(String[] args) {
        ParallelCourses2 parallelCourses2 = new ParallelCourses2();
        System.out.println(parallelCourses2.minNumberOfSemesters(5, new int[][]{{2, 1}, {3, 1}, {4, 1}, {1, 5}}, 2));
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        for (int[] r : relations) {
            pre[r[1] - 1] |= 1 << (r[0] - 1);
        }
        int[] dp = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            dp[i] = n;
            int can = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0 && (pre[j] & i) == pre[j]) {
                    can |= 1 << j;
                }
            }
            for (int sub = can; sub > 0; sub = (sub - 1) & can) {
                if (Integer.bitCount(sub) <= k) {
                    dp[i] = Math.min(dp[i], dp[i ^ sub] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
