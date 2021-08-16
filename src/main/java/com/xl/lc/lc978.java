package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc978
 * @Author : Xulian
 * @Date : 2020/11/18 21:27
 */
public class lc978 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = 0;
            }
        }
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (dp[i + 1][0] == 0) {
                dp[i + 1][0] = 1;
            }
            if (dp[i + 1][1] == 0) {
                dp[i + 1][1] = 1;
            }
            if (((i & 1) == 1) && arr[i] > arr[i + 1]) {
                dp[i][1] += dp[i + 1][1] + 1;
            }
            if (((i & 1) == 1) && arr[i] < arr[i + 1]) {
                dp[i][0] += dp[i + 1][0] + 1;
            }
            if (((i & 1) == 0) && arr[i] < arr[i + 1]) {
                dp[i][1] += dp[i + 1][1] + 1;
            }
            if (((i & 1) == 0) && arr[i] > arr[i + 1]) {
                dp[i][0] += dp[i + 1][0] + 1;
            }
            res = Math.max(Math.max(dp[i][0], dp[i][1]), res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(new lc978().maxTurbulenceSize(arr));
    }
}
