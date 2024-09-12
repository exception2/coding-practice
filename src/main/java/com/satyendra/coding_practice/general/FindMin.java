package general;

import java.util.ArrayList;
import java.util.List;

public class FindMin {
    public static void main(String[] args) {
        System.out.println(printResult(new int[]{33, 02, 40, 45, 23, 51, 24, 67, 78, 94}, 10));
    }
    public static int printResult(int[] arr, int n) {
        int result = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String a = Integer.valueOf(arr[i]).toString();
            i++;
            if(i<n) {
                a = a + Integer.valueOf(arr[i]).toString();
            }
            list.add(Integer.valueOf(a));
        }

        for (int i = 0; i < list.size(); i++) {
            result = Math.min(result, list.get(i));
        }
        return result;
    }
}
