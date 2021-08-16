package com.xl.jzoffer;

public class jz_53_2 {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
        System.out.println(new jz_53_2().missingNumber(nums));
    }
}
