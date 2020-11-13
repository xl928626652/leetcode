package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc75
 * @Author : Xulian
 * @Date : 2020/10/12 9:04
 */
public class lc75 {
    public void sortColors(int[] nums) {
        int i0 = 0, i2 = nums.length - 1;
        for (int i = 0; i <= i2; i++) {
            while (i <= i2 && nums[i] == 2) {
                if(i != i2){
                    swap(nums, i, i2);
                }
                i2--;
            }
            while (i > i0 && nums[i] == 0) {
                swap(nums, i, i0);
                i0++;
            }
        }
    }

    //这种方法的 a 和 b不能相同
    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
//    public void swap(int[] nums, int a, int b){
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2};
//        new lc75().sortColors(nums);
//        System.out.println(nums[0]);
        int[] nums = new int[]{2};
        new lc75().swap(nums,0,0);
        System.out.println(Arrays.toString(nums));


    }
}
