package general;

import java.util.List;

public class AllOverlappedPoints {
    public static void main(String[] args) {
        System.out.println(findOverlappedPoints(List.of(1, 2, 3), List.of(10, 8, 4)));
        System.out.println(findOverlappedPoints(List.of(1, 5, 5), List.of(5, 10, 5)));
    }

    private static int findOverlappedPoints(List<Integer> l1, List<Integer> l2) {
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        for(int i = 0; i < l1.size(); i++) {
            left = Math.max(left, l1.get(i));
            right = Math.min(right, l2.get(i));
        }
        return right - left + 1;
    }
}
