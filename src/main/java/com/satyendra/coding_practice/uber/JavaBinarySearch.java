package com.satyendra.coding_practice.uber;

import java.util.Collections;
import java.util.List;

public class JavaBinarySearch {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 2, 2, 4, 7, 13, 21);
        // System.out.println(Collections.binarySearch(list, 22));

        int[] arr = new int[]{2, 3, 4, 4, 4, 5, 9};
        System.out.println(findLowerIndex(arr, 4));
        System.out.println(findUpperIndex(arr, 4));
    }

    private static int findLowerIndex(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {

            int mid = (low + high)/2;
            if(arr[mid] == key) {
                res = mid;
                high = mid - 1;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static int findUpperIndex(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {

            int mid = (low + high)/2;
            if(arr[mid] == key) {
                res = mid;
                low = mid + 1;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
