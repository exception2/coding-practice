package com.satyendra.coding_practice.gfg;

import lombok.val;

import java.util.*;

public class DistinctSubsetSum {
    int[][] dp = new int[101][1001];
    public static void main(String[] args) {
        DistinctSubsetSum distinctSubsetSum = new DistinctSubsetSum();
        int[] res1 = distinctSubsetSum.distinctSubsetSum(new int[]{1,2,3});
        for(int i = 0 ; i < res1.length ; i++) {
            System.out.print(res1[i] + " ");
        }
        System.out.println();
    }

    public int[] DistinctSum(int[] nums)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for(int i = 0 ; i < nums.length ; i++) {
            int size = queue.size();
            Set<Integer> midSet = new HashSet<>();
            while(!queue.isEmpty()) {
                midSet.add(queue.poll());
            }
            for(Integer subSetSum : midSet){
                queue.add(subSetSum);
                queue.add(subSetSum + nums[i]);
            }
        }
        Set<Integer> set = new HashSet<>(queue);
        int[] res = new int[set.size()];
        int i = 0;
        for(Integer val : set) {
            res[i++] = val;
        }

        Arrays.sort(res);
        return res;
    }

    public int[] distinctSubsetSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < 101 ; i++) {
            Arrays.fill(dp[i], -1);
        }
        rec(nums, 0, 0, set);
        int[] res = new int[set.size()];
        int i = 0;
        for(Integer val : set) {
            res[i++] = val;
        }

        Arrays.sort(res);
        return res;
    }

    private void rec(int[] arr, int index, int sum, Set<Integer> set) {
        if(index == arr.length) {
            set.add(sum);
            return;
        }
        if(dp[index][sum] != -1) {
            return;
        }
        rec(arr, index + 1, sum, set);
        rec(arr, index + 1, sum + arr[index], set);
        dp[index][sum] = 1;
    }

}
