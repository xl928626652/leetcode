package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1716 {
    //dp 空间复杂度O（n）
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }
    //dp 空间复杂度 O（1）
}
