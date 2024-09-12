package general;

public class WeightLiftAmazon {
    public static void main(String[] args) {
        System.out.println(findMinimumMoves(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findMinimumMoves(new int[]{2, 4, 3, 1, 6}));
        System.out.println(findMinimumMoves(new int[]{2, 4, 6, 1, 3}));
        System.out.println(findMinimumMoves(new int[]{3, 2, 1}));
    }
    static int findMinimumMoves(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if(min == max) {
            return 0;
        }
        int minIndex = -1, maxIndex = -1, moves = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == min && minIndex == -1) {
                minIndex = i;
            }
            if(arr[i] == max) {
                maxIndex = i;
            }
        }
        moves = minIndex + (n-1-maxIndex);
        if(minIndex > maxIndex) {
            moves--;
        }
        return moves;
    }
}
