package com.xl.lc;

/**
 * @ClassName : lc494
 * @Author : Xulian
 * @Date : 2020/9/30 16:06
 */
public class lc494 {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(sum < S) return 0;
        if ((sum + S) % 2 != 0) return 0;
        sum = (sum + S) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = sum; nums[i] <= j; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[sum];
    }

}
