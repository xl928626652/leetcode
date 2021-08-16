package com.xl.lc;

/**
 * @ClassName : lc53
 * @Author : Xulian
 * @Date : 2020/10/28 20:10
 */
public class lc53_Mark {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(0, sum) + nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
