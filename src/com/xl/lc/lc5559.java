package com.xl.lc;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @ClassName : lc5559
 * @Author : Xulian
 * @Date : 2020/11/28 23:13
 */
public class lc5559 {
    public int minimumMountainRemovals(int[] nums) {
        int res = nums.length - 3;
        Deque<Integer> left = new LinkedList<>(), right = new LinkedList<>();
        int[] dpLeft = new int[nums.length];
        int[] dpRight = new int[nums.length];
        dpLeft[0] = 0;
        dpRight[nums.length - 1] = 0;
        left.offerLast(nums[0]);
        right.offerFirst(nums[nums.length - 1]);
        for (int i = 1; i < nums.length; i++) {
            int cnt = 0;
            if (nums[i] <= left.peekLast()) {
                while (!left.isEmpty() && nums[i] <= left.peekLast()) {
                    left.pollLast();
                    cnt++;
                }
                left.offerLast(nums[i]);
            } else {
                left.offerLast(nums[i]);
            }
            dpLeft[i] = dpLeft[i - 1] + cnt;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            int cnt = 0;
            if (nums[i] <= right.peekFirst()) {
                while (!right.isEmpty() && nums[i] <= right.peekFirst()) {
                    right.pollFirst();
                    cnt++;
                }
                right.offerFirst(nums[i]);
            } else {
                right.offerFirst(nums[i]);
            }
            dpRight[i] = dpRight[i + 1] + cnt;
        }
        System.out.println(Arrays.toString(dpLeft));
        System.out.println(Arrays.toString(dpRight));
        for (int i = 0; i < nums.length; i++) {
            res = Math.min(res, dpLeft[i] + dpRight[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 5, 6, 2, 3, 1};
        int res = new lc5559().minimumMountainRemovals(nums);
        System.out.println(res);
    }
}
