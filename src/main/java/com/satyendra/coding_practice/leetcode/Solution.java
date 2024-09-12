package leetcode;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length ; i++){
            if(amount - coins[i] >= 0) {
                int subRes = coinChange(coins, amount - coins[i]);
                if(subRes != Integer.MAX_VALUE && subRes + 1 < res) {
                    res = subRes + 1;
                }
            }
        }
        return res;
    }
    public int coinChangeDP(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1 ; i <= amount ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= amount ; i++) {
            for(int j = 0 ; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    int sub_res = dp[i - coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i]) {
                        dp[i] = sub_res + 1;
                    }
                }
            }
        }
        if(dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChangeDP(new int[]{1,2,3}, 11));
    }

    public int minOperations(int[] nums, int x) {
        int maxWindowSize = findMaxWindow(nums, Arrays.stream(nums).sum() - x);
        return nums.length - maxWindowSize;
    }

    private int findMaxWindow(int[] nums, int target) {
        int start = 0, temp = 0, maxLength = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ;) {
            while(i < nums.length && temp < target) {
                temp += nums[i];
                i++;
            }
            while(temp >= target) {
                if(temp == target) {
                    maxLength = Math.max(maxLength, i - start);
                }
                temp -= nums[start++];
            }
        }
        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }
}
