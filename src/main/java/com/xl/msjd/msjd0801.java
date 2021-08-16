package com.xl.msjd;

public class msjd0801 {
    //套路：每一步dp都要mod，且dp数组要开成long的，防止测试用例越界
    public int waysToStep(int n) {
        long[] dp = new long[n + 1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int mod = (int) 1e9 + 7;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        int a = (int) 1e9 + 7;
        System.out.println(a);
        System.out.println(1e9 + 7);
    }
}
