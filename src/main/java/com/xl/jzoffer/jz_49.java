package com.xl.jzoffer;

public class jz_49 {
    //非典型dp，可以参考大佬下面的那个题解，讲的好
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int t1 = dp[a] * 2, t2 = dp[b] * 3, t3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(t1, t2), t3);
            if (t1 == dp[i]) a++;
            if (t2 == dp[i]) b++;
            if (t3 == dp[i]) c++;
        }
        return dp[n - 1];
    }
}
