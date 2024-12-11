package com.satyendra.coding_practice.uber;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaxRotationSum {
    public static void main(String[] args) {
        MaxRotationSum maxRotationSum = new MaxRotationSum();
        System.out.println(maxRotationSum.maxSum(new int[]{8, 3, 1, 2}));
        System.out.println(maxRotationSum.maxSum(new int[]{3, 2, 1}));
    }

    private int maxSum(int[] arr) {
        int sum = 0, n = arr.length, res = 0;
        for(int i = 0 ; i < n ; i++) {
            sum += arr[i];
            res += (i*arr[i]);
        }

        for(int i = 1; i < n ; i++) {
            int curr = res - (sum - arr[i-1]) + (arr[i-1] * (n-1));
            res = Math.max(res, curr);
        }
        return res;
    }
}
