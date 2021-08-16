package com.xl.base;

/**
 * @ClassName : BubbleSort
 * @Author : Xulian
 * @Date : 2020/10/8 17:01
 */
public class BubbleSort {
    //稳定
    public void bubbleSort(int[] nums) {
        int exchange = nums.length - 1;
        int position, bound, temp;
        while (exchange != 0) {
            bound = exchange;
            exchange = 0;
            for (position = 0; position < bound; position++) {
                if (nums[position] > nums[position + 1]) {

                    swap(nums, position, position + 1);

                    exchange = position;
                }
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{50, 13, 55, 97, 27, 38, 49, 65};
        new BubbleSort().bubbleSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
