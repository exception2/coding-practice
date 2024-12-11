package com.satyendra.coding_practice.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllSubset {
    public static void main(String[] args) {
        PrintAllSubset printAllSubset = new PrintAllSubset();
        System.out.println(printAllSubset.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(printAllSubset.subsetsWithDup(new int[]{0}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetRec(nums, 0, res, false, Integer.MIN_VALUE, new ArrayList<Integer>());
        return res;
    }

    private void subsetRec(int[] arr, int i, List<List<Integer>> res, boolean isPreviousAdded, int lastAddedValue, List<Integer> ans) {
        if(i == arr.length) {
            res.add(ans);
            return;
        }
        if(lastAddedValue == arr[i]) {
            if(isPreviousAdded) {
                List<Integer> subset2 = new ArrayList<>(ans);
                subset2.add(arr[i]);
                subsetRec(arr, i + 1, res, false, arr[i], new ArrayList<>(ans));
                subsetRec(arr, i + 1, res, true, arr[i], subset2);
            } else {
                subsetRec(arr, i + 1, res, false, arr[i], new ArrayList<>(ans));
            }
        } else {
            List<Integer> subset2 = new ArrayList<>(ans);
            subset2.add(arr[i]);
            subsetRec(arr, i + 1, res, false , arr[i], new ArrayList<>(ans));
            subsetRec(arr, i + 1, res, true , arr[i], subset2);
        }
    }
}
