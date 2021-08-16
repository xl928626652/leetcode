package com.xl.alibaba;

import java.util.Arrays;

/**
 * @ClassName : QuickSortTest
 * @Author : Xulian
 * @Date : 2021/3/31 16:27
 */
public class QuickSortTest {
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[l] <= nums[r]) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
                l++;
            }
            while (l < r && nums[l] <= nums[r]) {
                l++;
            }
            if (l < r) {
                swap(nums, l, r);
                r--;
            }
        }
        return l;
    }

    public static void swap(int[] nums, int l, int r) {
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 56, 767, 4, 52, 325, 3, 12};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
