package com.xl.alibaba;

import java.util.Arrays;

import static com.xl.alibaba.QuickSortTest.swap;

/**
 * @ClassName : HeapSort
 * @Author : Xulian
 * @Date : 2021/3/31 17:41
 */
public class HeapSort {
    public void heapSort(int[] nums, int left, int right) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftUp(nums, i, right);
        }
        for (int i = 1; i < nums.length; i++) {
            swap(nums, 0, nums.length - i);
            siftUp(nums, 0, nums.length - i - 1);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void siftUp(int[] nums, int start, int last) {
        int max = start * 2 + 1;
        while (max <= last) {
            int end = max + 1;
            if (end <= last && nums[max] <= nums[end]) {
                max = end;
            }
            if (nums[start] <= nums[max]) {
                swap(nums, start, max);
            } else {
                break;
            }
            start = max;
            max = max * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 312, 4, 12, 421, 4, 12, 4, 12, 4, 456, 34, 6, 436, 346, (int) 2e9};
        new HeapSort().heapSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
