package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc5619
 * @Author : Xulian
 * @Date : 2020/12/7 12:48
 */
public class lc5619 {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int[] value = new int[1 << n];
        Arrays.fill(value, -1);
        int[] freq = new int[n + 1];
        for (int i = 1; i < (1 << n); i++) {
            int bits = Integer.bitCount(i);
            if (bits == n / k) {
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & i) > 0) {
                        freq[nums[j]]++;
                    }
                }
                boolean flag = true;
                for (int j = 0; j <= n; ++j) {
                    if (freq[j] > 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int max = 0, min = 17;
                    for (int j = 0; j < freq.length; j++) {
                        if (freq[j] == 1) {
                            max = Math.max(max, j);
                            min = Math.min(min, j);
                        }
                    }
                    value[i] = max - min;
                }
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & i) > 0) {
                        freq[nums[j]]--;
                    }
                }
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (Integer.bitCount(i) % (n / k) == 0) {
                for (int j = i; j > 0; j = (j - 1) & i) {
                    if (value[j] != -1 && dp[i ^ j] != -1) {
                        if (dp[i] == -1) {
                            dp[i] = dp[i ^ j] + value[j];
                        } else {
                            dp[i] = Math.min(dp[i], dp[i ^ j] + value[j]);
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
