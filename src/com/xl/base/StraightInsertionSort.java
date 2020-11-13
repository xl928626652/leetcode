package com.xl.base;

/**
 * @ClassName : StraightInsertionSort
 * @Author : Xulian
 * @Date : 2020/10/8 16:33
 */
public class StraightInsertionSort {
    public void insertSort(int[] nums) {
        int temp, position;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            for (position = i; position > 0 && temp < nums[position - 1]; position--) {
                nums[position] = nums[position - 1];
            }
            nums[position] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 30, 25, 9, 18};
        new StraightInsertionSort().insertSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
