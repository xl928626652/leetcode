package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1714_Mark {
    //有个疑问，为什么不能在pivot == k - 1的条件判断内部，对res进行赋值，非要等quickSort全部结束才能进行赋值。
    //知识收货： swap(nums, a, b),如果a == b 那么这个交换操作就会把nums[a]变成0，是一个bug
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public int partition(int first, int end, int[] nums) {
        while (first < end) {
            while (first < end && nums[first] <= nums[end]) {
                end--;
            }
            if (first < end) {
                swap(nums, first, end);
                first++;
            }
            while (first < end && nums[first] <= nums[end]) {
                first++;
            }
            if (first < end) {
                swap(nums, first, end);
                end--;
            }
        }
        return first;
    }

    public void quickSort(int[] nums, int first, int end, int k) {
        if (first >= end) {
            return;
        }
        int pivot = partition(first, end, nums);
        if (pivot == k - 1) {
            return;
        } else if (pivot >= k) {
            quickSort(nums, first, pivot - 1, k);
        } else {
            quickSort(nums, pivot + 1, end, k);
        }
    }
    //堆排序
//    public int[] smallestK(int[] arr, int k) {
//        return heapSort(arr, k);
//    }
//    public void swap(int[] nums, int a, int b){
//        nums[a] = nums[a] ^ nums[b];
//        nums[b] = nums[a] ^ nums[b];
//        nums[a] = nums[a] ^ nums[b];
//    }
//    public void sift(int siftNode, int last, int[] nums){
//        int max = siftNode * 2 + 1;
//        while(max <= last){
//            if(max < last && nums[max] > nums[max + 1]){
//                max++;
//            }
//            if(nums[siftNode] < nums[max]){
//                break;
//            }else{
//                swap(nums, siftNode, max);
//                siftNode = max;
//                max = siftNode * 2 + 1;
//            }
//        }
//    }
//    public int[] heapSort(int[] nums,int k){
//        int[] res = new int[k];
//        for (int index = nums.length / 2 - 1; index >= 0; index--){
//            sift(index,nums.length - 1, nums);
//        }
//        for (int i = 1; i <= k; i++){
//            res[i-1]=nums[0];
//            swap(nums, 0, nums.length - i);
//            sift(0,nums.length - i - 1, nums);
//        }
//        return res;
//    }

}
