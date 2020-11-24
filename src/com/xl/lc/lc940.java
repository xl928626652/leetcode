package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc940
 * @Author : Xulian
 * @Date : 2020/11/20 19:42
 */
public class lc940 {
    public int distinctSubseqII(String S) {
        int mod = (int) 1e9 + 7;
        int n = S.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 % mod;
            int index = S.charAt(i - 1) - 'a';
            if (last[index] != -1) {
                dp[i] -= dp[last[index]];
            }
            dp[i] = (dp[i] + mod) % mod;
            last[index] = i - 1;
        }
        dp[n]--;
        return dp[n] % mod;
    }

//    public int distinctSubseqII(String S) {
//        int MOD = 1_000_000_007;
//        int N = S.length();
//        int[] dp = new int[N+1];
//        dp[0] = 1;
//
//        int[] last = new int[26];
//        Arrays.fill(last, -1);
//
//        for (int i = 0; i < N; ++i) {
//            int x = S.charAt(i) - 'a';
//            dp[i+1] = dp[i] * 2 % MOD;
//            if (last[x] >= 0)
//                dp[i+1] -= dp[last[x]];
//            dp[i+1] %= MOD;
//            last[x] = i;
//        }
//
//        dp[N]--;
//        if (dp[N] < 0) dp[N] += MOD;
//        return dp[N];
//    }

    //    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
        String S = "abc";
        int res = new lc940().distinctSubseqII(S);
        System.out.println(res);
    }
}
