package com.xl.msjd;

/**
 * @ClassName : msjd0811
 * @Author : Xulian
 * @Date : 2020/10/3 20:53
 */
public class msjd0811 {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{25, 10, 5, 1};
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < n + 1; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % (int)(1e9+7);
            }
        }
        return dp[n];
    }

}
