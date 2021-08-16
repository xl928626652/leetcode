package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc12
 * @Author : Xulian
 * @Date : 2020/11/20 12:04
 */
public class lc1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] ints : dp) Arrays.fill(ints, (int) -1e6);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = nums1[i - 1] * nums2[j - 1];
                dp[i][j] = Math.max(dp[i - 1][j - 1] + dp[i][j], dp[i][j]);
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);

            }
        }
        return dp[m][n];
    }
//    public int maxDotProduct(int[] nums1, int[] nums2) {
//        int m = nums1.length, n = nums2.length;
//        int max = Integer.MIN_VALUE;
//        int[][][][] dp = new int[m][m][n][n];
//        int minLen = Math.min(m, n);
//        for (int len = 1; len <= minLen; len++) {
//            for (int st1 = 0; st1 + len - 1 < m; st1++) {
//                for (int st2 = 0; st2 + len - 1 < n; st2++) {
//                    int e1 = st1 + len - 1, e2 = st2 + len - 1;
//                    if (len == 1) {
//                        for (int i = 0; i < m; i++) {
//                            for (int j = 0; j < n; j++) {
//                                dp[i][i][j][j] = nums1[i] * nums2[j];
//                                max = Math.max(max, dp[i][i][j][j]);
//                            }
//                        }
//                    } else {
//                        if (nums1[st1] * nums2[st2] <= 0) {
//                            dp[st1][e1][st2][e2] = dp[st1 + 1][e1][st2 + 1][e2];
//                        } else if (nums1[e1] * nums2[e2] <= 0) {
//                            dp[st1][e1][st2][e2] = dp[st1][e1 - 1][st2][e2 - 1];
//                        } else {
//                            dp[st1][e1][st2][e2] = Math.max(dp[st1 + 1][e1][st2 + 1][e2] + nums1[st1] * nums2[st2], dp[st1][e1 - 1][st2][e2 - 1] + nums1[e1] * nums2[e2]);
//                            dp[st1][e1][st2][e2] = Math.max(dp[st1][e1][st2][e2], nums1[st1] * nums2[st2]);
//                            dp[st1][e1][st2][e2] = Math.max(dp[st1][e1][st2][e2], nums1[e1] * nums2[e2]);
//                        }
//                        max = Math.max(max, dp[st1][e1][st2][e2]);
//                    }
//                }
//            }
//        }
//        return max;
//    }
}
