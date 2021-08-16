package com.xl.base;

public class BinarySearch {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int left, int right, int target) {
        if (right - left < 0) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(binarySearch.search(nums, nums[i]));
        }

    }
}