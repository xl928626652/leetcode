package com.xl.lc;

/**
 * @ClassName : lc516
 * @Author : Xulian
 * @Date : 2020/11/23 20:43
 */
public class lc516_Mark_Mark_Mark {
    public int longestPalindromeSubseq(String s) {
        //我们定义dp[i][j]为区间i ~ j之间的最长子回文序列的长度。
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int start = 1; start + len - 1 <= n; start++) {
                int end = start + len - 1;
                if (len == 1) dp[start][start] = 1;
                else {
                    if (chars[start - 1] == chars[end - 1]) {
                        dp[start][end] = dp[start + 1][end - 1] + 2;
                    } else {
                        dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
