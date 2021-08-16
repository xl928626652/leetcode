package com.xl.alibaba;

import java.util.Arrays;

/**
 * @ClassName : MergeSort
 * @Author : Xulian
 * @Date : 2021/3/31 16:49
 */
public class MergeSort {

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void mergeSortNotRecur(int[] nums, int left, int right) {
        int h = 1;
        while (h <= nums.length) {
            for (int i = 0; i < nums.length; i += 2 * h) {
                merge(nums, i, i + h - 1, Math.min(i + 2 * h - 1, nums.length - 1));
            }
            h = h * 2;
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int l = left, r = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[index++] = nums[l++];
            } else {
                temp[index++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[index++] = nums[l++];
        }
        while (r <= right) {
            temp[index++] = nums[r++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    public void mergeSortO1(int[] nums, int left, int right, int maxVal) {
        if (left >= right) {
            return;
        } else {
            int mid = left + (right - left) / 2;
            mergeSortO1(nums, left, mid, maxVal);
            mergeSortO1(nums, mid + 1, right, maxVal);
            mergeO1(nums, left, mid, right, maxVal);
        }
    }

    public void mergeO1(int[] nums, int left, int mid, int right, int maxValue) {
        int l = left, r = mid + 1;
        int index = left;
        while (l <= mid && r <= right) {
            if (nums[l] % maxValue <= nums[r] % maxValue) {
                nums[index++] += nums[l++] % maxValue * maxValue;
            } else {
                nums[index++] += nums[r++] % maxValue * maxValue;
            }
        }
        while (l <= mid) {
            nums[index++] += nums[l++] % maxValue * maxValue;
        }
        while (r <= right) {
            nums[index++] += nums[r++] % maxValue * maxValue;
        }
        for (int i = left; i <= right; i++) {
            nums[i] /= maxValue;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 312, 4, 12, 421, 4, 12, 4, 12, 4, 456, 34, 6, 436, 346};
//        [4, 4, 4, 4, 6, 12, 12, 12, 12, 34, 312, 346, 421, 436, 456]
//        new MergeSort().mergeSort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//        [4, 4, 4, 4, 6, 12, 12, 12, 12, 34, 312, 346, 421, 436, 456]
//        new MergeSort().mergeSortNotRecur(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));

//        [4, 4, 4, 4, 6, 12, 12, 12, 12, 34, 312, 346, 421, 436, 456]
        int maxValue = Arrays.stream(nums).max().getAsInt() + 1;
        new MergeSort().mergeSortO1(nums, 0, nums.length - 1, maxValue);
        System.out.println(Arrays.toString(nums));
    }
}
