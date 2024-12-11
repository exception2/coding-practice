package com.satyendra.coding_practice.phonepe;

public class FindMissingElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 4, 4, 1, 1, 2, 2, 4, 4, 3, 3, 3};
        System.out.println("Single element is: " + findSingleElement(arr));
    }

    private static int findSingleElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(mid % 2 == 1) mid--;
            if(arr[mid] == arr[mid+1]) {
                left = mid+2;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }
}
