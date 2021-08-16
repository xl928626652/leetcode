package com.xl.lc;

/**
 * @ClassName : lc5639
 * @Author : Xulian
 * @Date : 2021/1/10 17:10
 */
public class lc5639 {
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[][] dp = new int[k][1 << n];
        int[] total = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    total[i] = total[i - (1 << j)] + jobs[j];
                    break;
                }
            }
        }
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = total[i];
        }
        for (int i = 1; i < k; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                int min = Integer.MAX_VALUE;
                for (int s = mask; s > 0; s = ((s - 1) & mask)) {
                    int left = mask - s;
                    min = Math.max(dp[i - 1][left], total[s]);
                }
                dp[i][mask] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }

    public static void main(String[] args) {
        int[] jobs = new int[]{};
    }
}
