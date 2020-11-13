package com.xl.jzoffer;

public class jz_53_1 {
    //暴力法，没什么意思
//    public int search(int[] nums, int target) {
//        int num = 0;
//        boolean bool = false;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) num++;
//        }
//        return num;
//    }
    //二分法，因为这是有序数组
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        int index = 0;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        for (int i = index; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            } else {
                count++;
            }
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new jz_53_1().search(nums, 3));
    }
}
