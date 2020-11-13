package com.xl.lc;

/**
 * @ClassName : lc474
 * @Author : Xulian
 * @Date : 2020/9/30 17:01
 */
public class lc474 {
    //三维
//    public int findMaxForm(String[] strs, int m, int n) {
//        int len = strs.length;
//        if (len == 0) return 0;
//        int[][][] dp = new int[len + 1][m + 1][n + 1];
//        for (int i = 1; i < len + 1; i++) {
//            int[] res = computeNumber(strs[i - 1]);
//            for (int j = 0; j < m + 1; j++) {
//                for (int k = 0; k < n + 1; k++) {
//                    if (j >= res[0] && k >= res[1]) {
//                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - res[0]][k - res[1]] + 1);// 这个+1特别灵性
//                    }
//                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
//                }
//            }
//        }
//        return dp[len][m][n];
//    }
    //二维
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        if (len == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs){
            int[] res = computeNumber(s);
            for (int i = m; i > -1; i--) {
                for (int j = n; j > -1; j--) {
                    if(i>=res[0] && j>=res[1]){
                        dp[i][j]=Math.max(dp[i-res[0]][j-res[1]]+1,dp[i][j]);//+1 是因为要算价值
                    }
                }
            }
        }
        return dp[m][n];
    }
    public int[] computeNumber(String s) {
        char[] chars = s.toCharArray();
        int[] res = new int[2];
        for (char c : chars) {
            res[c - '0']++;
        }
        return res;
    }
}
