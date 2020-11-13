package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1616 {
    public int[] subSort(int[] array) {
        if (array.length <= 1) {
            return new int[]{-1, -1};
        }
        int left = -1, right = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                left = i;
                break;
            }
        }
        if (left == -1) return new int[]{-1, -1};
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                right = i;
                break;
            }
        }
        int min = array[left], max = array[right];
        for (int i = left; i <= right; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        for (int i = 0; i <= left; i++) {
            if (array[i] > min) {
                left = i;
                break;
            }
        }
        for (int i = array.length - 1; i >= right; i--) {
            if (array[i] < max) {
                right = i;
                break;
            }
        }

        return new int[]{left, right};
    }
//    int left,right;
//    public int[] subSort(int[] array) {
//        if(array.length<=1){
//            return new int[]{-1,-1};
//        }
//        left = array.length-1;right=0;
//        quickSort(0,array.length-1,array);
//        if(left==array.length-1 && right == 0){
//            return new int[]{-1,-1};
//        }
//        return new int[]{left,right};
//    }
//    public int partition(int first, int end, int[] nums) {
//        int i = first, j = end;
//        while (i < j) {
//            while (i < j && nums[i] <= nums[j]) {
//                j--;
//            }
//            if (i < j) {
//                swap(nums,i,j);
//                i++;
//            }
//            while (i < j && nums[i] <= nums[j]) {
//                i++;
//            }
//            if (i < j) {
//                swap(nums,i,j);
//                j--;
//            }
//        }
//        return i;
//    }
//
//    public void quickSort(int first, int end, int[] nums) {
//        if (first >= end) {
//            return;
//        } else {
//            int pivot = partition(first, end, nums);
//            quickSort(first, pivot - 1, nums);
//            quickSort(pivot + 1, end, nums);
//        }
//    }
//    public void swap(int[] nums, int a, int b){
//        left = Math.min(left,a);
//        right = Math.max(right,b);
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }

}
