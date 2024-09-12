package general;

public class PlateCandles {
    public static void main(String[] args) {
        PlateCandles pc = new PlateCandles();
        int[] arr = pc.platesBetweenCandles("**|**|***|", new int[][]{{2,5},{5,9}});
        for(int i : arr) {
            System.out.println(i);
        }
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0 ; i < n ; i++) {
            left[i] = (i>0 ? left[i-1] : 0) + ((s.charAt(i)=='|') ? 1 : 0);
        }
        for(int i = n-1 ; i >= 0 ; i--) {
            right[i] = (i<n-1 ? right[i+1] : 0) + ((s.charAt(i)=='|') ? 1 : 0);
        }
        int q = queries.length;
        int[] ans = new int[q];
        int k = 0;
        for(int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int rl = l > 0 ? left[l-1] : 0;
            int rr = r < n-1 ? right[r+1] : 0;
            int count = 0;
            for(int i = l; i<=r;i++) {
                if(s.charAt(i) == '*') {
                    if(left[i] - rl > 0 && right[i] - rr > 0) {
                        count++;
                    }
                }
            }
            ans[k++] = count;
        }
        return ans;
    }
}
