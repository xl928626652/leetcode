package com.xl.base;

import java.util.Arrays;

/**
 * @ClassName : QuickSort
 * @Author : Xulian
 * @Date : 2020/10/8 21:36
 */
public class QuickSort {
    //这个版本的快排有个特点，就是first和end相同时排序结束。在做一些题时需要注意，不能在pivot的地方做判断，要在排序算法跳出后赋值
    public int partition(int first, int end, int[] nums) {
        int i = first, j = end;
        while (i < j) {
            while (i < j && nums[i] <= nums[j]) {
                j--;
            }
            if (i < j) {
                swap(nums,i,j);
                i++;
            }
            while (i < j && nums[i] <= nums[j]) {
                i++;
            }
            if (i < j) {
                swap(nums,i,j);
                j--;
            }
        }
        return i;
    }

    public void quickSort(int first, int end, int[] nums) {
        if (first >= end) {
            return;
        } else {
            int pivot = partition(first, end, nums);
            quickSort(first, pivot - 1, nums);
            quickSort(pivot + 1, end, nums);
        }
    }
    public void swap(int[] nums, int a, int b){
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{50, 13, 55, 97, 27, 38, 49, 65};
//        int[] nums = {3, 4, 5, 2, 1, 7, 6, 9, 8, 0};
        new QuickSort().quickSort(0, nums.length - 1, nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }
}
