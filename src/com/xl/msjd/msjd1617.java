package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1617 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==0) return 0;
        dp[0]=nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
