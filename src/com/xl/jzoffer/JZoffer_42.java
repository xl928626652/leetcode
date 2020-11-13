package com.xl.jzoffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JZoffer_42 {
    //暴力法
    /*public int maxSubArray(int[] nums) {
        int max = -100;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp >= max) max = temp;
            }
        }
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1], max);
    }*/
    //动归
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int[] dp=new int[nums.length];
        dp[0]=max;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println();
    }
}
