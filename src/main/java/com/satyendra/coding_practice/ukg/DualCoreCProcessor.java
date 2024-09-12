package ukg;

import java.util.Arrays;
import java.util.Collections;

class DualCoreProcessor {
    public static int[] maxProcessTime(int n, int[] time) {
        // Arrays to store the cumulative times for each core
        Arrays.sort(time);
        Collections.reverse(Arrays.asList(time));
        int sumCore1 = 0;
        int sumCore2 = 0;

        // Iterate over each process time
        for (int i = 0; i < n; i++) {
            // Choose the best option for the core with the latch
            if (sumCore1 <= sumCore2) {
                sumCore1 += time[i];
            } else {
                sumCore2 += time[i];
            }
        }

        return new int[] { sumCore1, sumCore2 };
    }

    public static void main(String[] args) {
        int[] time = {10, 21, 10, 21, 10};
        int[] result = maxProcessTime(time.length, time);

        System.out.println(result[0] + " " + result[1]);
    }
}

