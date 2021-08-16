package com.xl.jzoffer;

public class JZoffer_10_1 {
    public int fib(int n) {
        //递归 时间复杂度高
        // if(n==0) return 0;
        // if(n==1) return 1;
        // return fib(n-1)+fib(n-2);
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=(dp[i-1]+dp[i-2]);
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
