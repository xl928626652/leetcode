package com.xl.jzoffer;

public class JZoffer_10_2 {
    public int numWays(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
            dp[i] %= 1e9+7;
        }
        return dp[n];


    }
}
