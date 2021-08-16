package com.xl.lc;

/**
 * @ClassName : lc629
 * @Author : Xulian
 * @Date : 2020/11/20 22:45
 */
public class lc629 {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1 && j <= (i * (i - 1)) / 2; j++) {
                if (i == 0) dp[i][j] = 0;
                else {
                    if (j == 0) dp[i][j] = 1;
                    else {
                        //重复计算了
//                        for (int l = 0; j >= l && l <= i - 1; l++) {
//                            dp[i][j] += dp[i - 1][j - l];
//                            dp[i][j] %= mod;
//                        }
                        //可以发现，尾项居然也变了，不止首项会变，可以自己在纸上推一推
                        int val = (dp[i - 1][j] + mod - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % mod;
                        dp[i][j] = (dp[i][j - 1] + val) % mod;
                    }
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int res = new lc629().kInversePairs(233, 123);
        System.out.println(res);
    }
}
