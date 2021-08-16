package com.xl.bilibili;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @ClassName : Question
 * @Author : Xulian
 * @Date : 2021/4/5 20:56
 */
public class Question {
    public static long stepsFirst(long n) {
        long[] dp = new long[(int) (n + 1)];
        dp[0] = 1;
        for (long i = 1; i <= n; i++) {
            dp[(int) i] = 2 * dp[(int) (i - 1)];
        }
        System.out.println(Arrays.toString(dp));
        return dp[(int) n];
    }

    public static long stepsSecond(long n) {
        long[] dp = new long[(int) (n + 1)];
        dp[0] = 1;
        for (long i = 1; i <= n; i++) {
            for (long j = i - 1; j >= 0; j--) {
                dp[(int) i] += dp[(int) j];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[(int) n];
    }

    public static void main(String[] args) {
        long n = 63;
        long ans1 = stepsFirst(n);
        long ans2 = stepsFirst(n);
        System.out.println("ans1 +" + ans1);
        System.out.println("ans2 +" + ans2);
        BigInteger bigInteger = new BigInteger(String.valueOf(Long.MAX_VALUE) + String.valueOf(Long.MAX_VALUE));
        System.out.println(bigInteger.add(new BigInteger("142124124121")));
        System.out.println(bigInteger);
        System.out.println(Long.MAX_VALUE);
    }
}
