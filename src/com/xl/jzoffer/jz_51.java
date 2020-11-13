package com.xl.jzoffer;

public class jz_51 {
    int count = 0;

    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return count;
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);

    }

    public void merge(int[] nums, int left, int mid, int right) {
        int leftIndex = left, rightIndex = mid + 1;
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            //这里的>=换成<=就是升序，不然是降序
            if (nums[leftIndex] > nums[rightIndex]) {
                count = count + right - rightIndex + 1;//这行是本题的关键，把这行去掉的话，剩下的代码就是一个基于归并的降序排序
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
}
