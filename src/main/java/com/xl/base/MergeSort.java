package com.xl.base;

public class MergeSort {
    public void recurSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        recurSort(nums, left, mid);
        recurSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void notRecurSort(int[] nums) {
        int h = 1;
        while (h < nums.length) {
            mergePass(h, nums);
            h = 2 * h;
        }
    }

    //非递归时
    public void mergePass(int h, int[] nums) {
        int i = 0;
        while (i <= nums.length - 2 * h - 1) {
            merge(nums, i, i + h - 1, i + 2 * h - 1);
            i = i + 2 * h;
        }
        if (i < nums.length - h + 1) {
            merge(nums, i, i + h - 1, nums.length - 1);
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int leftIndex = left, rightIndex = mid + 1;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {

            //这里的>=换成<=就是升序，不然是降序
            if (nums[leftIndex] >= nums[rightIndex]) {
                temp[tempIndex++] = nums[leftIndex++];
            } else {
                temp[tempIndex++] = nums[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            temp[tempIndex++] = nums[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = nums[rightIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2, 1, 7, 6, 9, 8, 0};
//        new MergeSort().recurSort(nums, 0, nums.length - 1);
        new MergeSort().notRecurSort(nums);
        for (int i : nums) System.out.println(i);
    }

}
