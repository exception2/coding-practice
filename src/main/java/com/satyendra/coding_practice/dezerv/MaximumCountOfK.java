package com.satyendra.coding_practice.dezerv;

public class MaximumCountOfK {
    public static void main(String[] args) {
        MaximumCountOfK maximumCountOfK = new MaximumCountOfK();
        System.out.println(maximumCountOfK.findCountOfK(new int[]{6, 2, 6}, 2));
        System.out.println(maximumCountOfK.findCountOfK(new int[]{6, 2, 2, 2, 2, 4, 6, 6, 6}, 2));
    }

    private int findCountOfK(int[] arr, int k) {
        int maxCount = subArrayWithSameElement(arr, k);
        int kCount = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == k) {
                kCount++;
            }
        }
        return maxCount + kCount;
    }

    private int subArrayWithSameElement(int[] arr, int k) {
        int maxCount = 0, tempCount = 1;
        int lastElement = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(lastElement == arr[i]) {
                tempCount++;
            } else {
                if(lastElement != k) {
                    maxCount = Math.max(maxCount, tempCount);
                }
                tempCount = 1;
                lastElement = arr[i];
            }
        }
        if(lastElement != k) {
            maxCount = Math.max(maxCount, tempCount);
        }
        return maxCount;
    }
}
