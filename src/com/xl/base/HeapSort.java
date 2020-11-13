package com.xl.base;

/**
 * @ClassName : HeapSort
 * @Author : Xulian
 * @Date : 2020/10/9 19:48
 */
public class HeapSort {
    //不稳定，对初始序列的有序状态不敏感，这是它与快排最大的区别
    public void sift(int siftNode, int last, int[] nums) {
        int max = 2 * siftNode + 1;
        while (max <= last) {
            if (max < last && nums[max] < nums[max + 1]) {// nums[max] > nums[max + 1]
                max++;
            }
            if (nums[siftNode] > nums[max]) { // nums[siftNode] < nums[max]
                break;
            } else {
                swap(nums, siftNode, max);
                siftNode = max;
                max = 2 * siftNode + 1;
            }
        }
    }

    public void heapSort(int[] nums) {
        for (int index = nums.length / 2 - 1; index >= 0; index--) {
            sift(index, nums.length - 1, nums);
        }
        for (int i = 1; i < nums.length; i++) {
            swap(nums, 0, nums.length - i);
            sift(0, nums.length - i - 1, nums);
        }
    }

    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{36, 30, 18, 40, 32, 45, 22, 50};
        new HeapSort().heapSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }

        //         65
        //     50      55
        //  13   27  38    49
        //97
    }
}
