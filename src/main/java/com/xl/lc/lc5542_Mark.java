package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc5542
 * @Author : Xulian
 * @Date : 2020/11/1 16:58
 */
public class lc5542_Mark {
    //    int res;
//
//    public int numWays(String[] words, String target) {
//        res = 0;
//        if (words.length == 0 || words == null) {
//            return 0;
//        }
//        int max = words[0].length();
//        for (String word : words) {
//            max = Math.max(max, words.length);
//        }
//        recur(words, 0, target, max, 0);
//        return res;
//    }
//
//    public void recur(String[] words, int index, String target, int max, int k) {
//        if (index >= max && k != target.length()) {
//            return;
//        }
//        if (k == target.length()) {
//            res++;
//            res %= (int) (1e9 + 7);
//            return;
//        }
//        for (int i = index; i < max; i++) {
//            for (String word : words) {
//                if (i >= word.length()) {
//                    continue;
//                }
//                if (word.charAt(i) == target.charAt(k)) {
//                    recur(words, index + 1, target, max, k + 1);
//                }
//            }
//        }
//
//    }
    public int numWays(String[] words, String target) {
        int n = words[0].length(), m = target.length(), mod = 1000000007;
        int[] count = new int[26];
        long[][] dp = new long[n + 1][m + 1]; //空间设置为[n+1][m+1]是为了处理空串的边界情况。dp[i][j]表示使用前i-1个下标，组成target第j-1个字符。
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(count, 0);  //每轮count必须重置为0，记录下标为i-1的字符的数量。
            for (String s : words) {
                count[s.charAt(i - 1) - 'a']++;
            }
            dp[i][0] = 1; //target为空串
            for (int j = 1; j <= m && j <= i; j++) {
                dp[i][j] = dp[i - 1][j]; //不使用下标i
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * count[target.charAt(j - 1) - 'a']) % mod; //使用下标i，乘法原理
            }
        }
        return (int) dp[n][m];
    }

    public static void main(String[] args) {
        String[] words = new String[]{"acca", "bbbb", "caca"};
        String target = "aba";
        new lc5542_Mark().numWays(words, target);
    }
}
