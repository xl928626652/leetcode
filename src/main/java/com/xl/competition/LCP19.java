package com.xl.competition;


import java.util.Arrays;

public class LCP19 {
    // 三目运算符要把整体用括号括起来，否则问题如下：
    //    System.out.println(('r' == 'r' ? 1 : 0) + 1); 2
    //    System.out.println('r' == 'r' ? 1 : 0 + 1); 1 因为这样,会把0 + 1作为一个整体.
    public int minimumOperations(String leaves) {
        char[] chars = leaves.toCharArray();
        int[][] dp = new int[3][chars.length];
        dp[0][0] = chars[0] == 'r' ? 0 : 1;
        dp[1][1] = dp[0][0] + (chars[1] == 'y' ? 0 : 1);
        dp[2][2] = dp[1][1] + (chars[2] == 'r' ? 0 : 1);

        for (int i = 1; i < chars.length; i++) {
            if (i == 1) {
                dp[0][i] = dp[0][i - 1] + (chars[i] == 'r' ? 0 : 1);
                continue;
            }
            if (i == 2) {
                dp[0][i] = dp[0][i - 1] + (chars[i] == 'r' ? 0 : 1);
                dp[1][i] = Math.min(dp[1][i - 1] + (chars[i] == 'y' ? 0 : 1), dp[0][i - 1] + (chars[i] == 'y' ? 0 : 1));
                continue;
            }
            dp[0][i] = dp[0][i - 1] + (chars[i] == 'r' ? 0 : 1);
            dp[1][i] = Math.min(dp[1][i - 1] + (chars[i] == 'y' ? 0 : 1), dp[0][i - 1] + (chars[i] == 'y' ? 0 : 1));
            dp[2][i] = Math.min(dp[2][i - 1] + (chars[i] == 'r' ? 0 : 1), dp[1][i - 1] + (chars[i] == 'r' ? 0 : 1));
        }
        return dp[2][chars.length - 1];
    }


    public static void main(String[] args) {
        String s = "rrryyyrryyyrr";
        System.out.println(s);
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = chars[0] == 'r' ? 0 : 1;
        for (int i = 1; i < chars.length; i++) {
            dp[i] = dp[i - 1] + chars[i] == 'r' ? 0 : 1;
        }
        for (int i : dp) {
            System.out.print(i);
        }
        System.out.println("");
        System.out.println("----------------");
        for (int i = 1; i < chars.length; i++) {
            dp[i] = dp[i - 1] + (chars[i] == 'r' ? 0 : 1);
        }
        for (int i : dp) {
            System.out.print(i);
        }
        System.out.println("****");
        System.out.println(('r' == 'r' ? 1 : 0) + 1);
    }
}
