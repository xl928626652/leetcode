package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc5
 * @Author : Xulian
 * @Date : 2020/11/12 17:35
 */
public class lc5_Mark_DP {
    //O(n2)的dp 不如最快的O（n）方法
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) return s;
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = true;
//        }
//        int begin = 0, end = 0;
//        for (int i = n - 1; i >= 0 ; i--) {
//            for (int j = i + 1; j < n ; j++) {
//                if (s.charAt(i) == s.charAt(j)){
//                    if (j - i == 1){
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                } else {
//                    dp[i][j] = false;
//                }
//                if (j - i > end - begin && dp[i][j]){
//                    begin = i;
//                    end = j;
//                }
//            }
//        }
//        return s.substring(begin,end + 1);
//    }
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        System.out.println(n);
        boolean[][] dp = new boolean[n + 1][n + 1];
        int left = 0, right = 0;
        for (int i = n; i >= 1; i++) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                }
                if (i == j - 1) {
                    if (chars[i - 1] == chars[j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (i < j - 1) {
                    if (chars[i - 1] == chars[j - 1]) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && right - left < j - i) {
                    left = i - 1;
                    right = j - 1;
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println("here" + ":" + left + ":" + right);
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        String ret = new lc5_Mark_DP().longestPalindrome(s);
        System.out.println(ret);
    }

    //中心拓展 这个做法应该是很直观的，所有的回文分为两种：奇数长度和偶数长度
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) {
//            return "";
//        }
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    public int expandAroundCenter(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
//        }
//        return right - left - 1;
//    }
}
