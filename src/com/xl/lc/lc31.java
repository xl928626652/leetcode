package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc31
 * @Author : Xulian
 * @Date : 2020/11/10 19:50
 */
public class lc31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int max = n - 2;
        while (max >= 0 && nums[max] >= nums[n - 1]){
            max--;
        }
        if (max >= 0){
            int min = n - 1;
            while (min >= 0 && nums[min] <= nums[max]){
                min--;
            }
            swap(nums, min, max);
        }
        Arrays.sort(nums,max + 1, n);
    }
    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
