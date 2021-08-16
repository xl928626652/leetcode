package com.xl.jzoffer;

import java.util.Arrays;

public class jz_61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                index = Math.min(index, i);
            } else {
                count++;
            }
        }
        for (int i = index + 1; i < nums.length; i++) {

            while (nums[i] - nums[i-1] != 1 && count >= 0) {
                count--;
                nums[i-1]++;
            }
            if (count < 0) return false;

        }
        return true;
    }

    //https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
    //可以看看大佬的Set
}
