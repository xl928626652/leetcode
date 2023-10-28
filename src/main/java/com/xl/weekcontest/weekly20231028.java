package com.xl.weekcontest;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class weekly20231028 {

    public static int sumCounts(List<Integer> nums) {
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                sum += set.size() * set.size();
                sum %= mod;
            }
        }
        return sum;
    }

    /**
     * 背包dp,很简单，遍历nums,每个num选或者不选，就是一个dp。时间复杂度O（n * target）
     * @param nums
     * @param target
     * @return
     */
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target+1];
        int n = nums.size();
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                if (dp[t - num] != -1) {
                    dp[t] = Math.max(dp[t], dp[t - num] + 1);
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5);
        int i = sumCounts(list);
        System.out.println(i);
    }
}
