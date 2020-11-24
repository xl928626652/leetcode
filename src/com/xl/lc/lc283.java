package com.xl.lc;

/**
 * @ClassName : lc283
 * @Author : Xulian
 * @Date : 2020/11/20 11:08
 */
public class lc283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        int zeroCount = 0;
        for (int i : nums) if (i == 0) zeroCount++;
        for (int i = 0; i < n - zeroCount; i++) {
            while (index < n && nums[index] != 0) index++;
            if ((nums[i] != 0) && (i > index)) {
                swap(nums, i, index);
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
