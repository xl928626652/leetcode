package com.xl.base;

/**
 * @ClassName : ShellSort
 * @Author : Xulian
 * @Date : 2020/10/8 16:44
 */
public class ShellSort {
    //不稳定的排序，时间复杂度介于 nlogn和n2之间，如果d选的好，可以达到n1.3
    public void shellSort(int[] nums) {
        int temp, position;
        for (int d = nums.length / 2; d >= 1; d /= 2) {
            for (int i = d; i < nums.length; i++) {
                temp = nums[i];
                for (position = i; position - d >= 0 && temp < nums[position - d]; position = position - d) {
                    nums[position] = nums[position - d];
                }
                nums[position] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{59,20,17,36,98,14,23,83,13,28};
        new ShellSort().shellSort(nums);
        for (int i : nums){
            System.out.print(i+" ");
        }
    }
}
