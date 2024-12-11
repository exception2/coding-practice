package com.satyendra.coding_practice.general;

import java.util.Arrays;

public class SmallestPairDistance {
    public static void main(String[] args) {
        SmallestPairDistance smallestPairDistance = new SmallestPairDistance();
        System.out.println(smallestPairDistance.smallestDistancePair(new int[]{1,3,1, 1}, 4));
    }

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n-1] - nums[0];

        while (low < high) {
            int mid = (low+high)/2;

            if(countWithDistance(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countWithDistance(int[] nums, int distance) {
        int j = 1;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            while (j < nums.length && nums[j] - nums[i] <= distance) {
                j++;
            }
            count += (j - i - 1);
        }
        return count;
    }
}
