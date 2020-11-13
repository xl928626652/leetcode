package com.xl.base;

/**
 * @ClassName : SelectSort
 * @Author : Xulian
 * @Date : 2020/10/9 15:38
 */
public class SelectSort {
    public void selectSort(int[] nums) {
        int index, temp;
        for (int i = 0; i < nums.length - 1; i++) {
            index = i;
            for (int scan = i + 1; scan < nums.length; scan++) {
                if (nums[scan] < nums[index]) {
                    index = scan;
                }
            }
            if (index != i) {
                swap(nums, i, index);
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{50, 13, 55, 97, 27, 38, 49, 65};
        new SelectSort().selectSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
