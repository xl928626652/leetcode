package com.xl.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : lc300
 * @Author : Xulian
 * @Date : 2020/11/18 15:23
 */
public class lc300 {
    //O（n2）
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]){
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[n - 1];
//    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.size() == 0 || list.get(list.size() - 1) < num) {
                list.add(num);
            }
            int index = Collections.binarySearch(list, num);
            index = index < 0 ? -index - 1 : index;
            list.remove(index);
            list.add(index, num);
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 8, 9, 10, 14};
        int index = Arrays.binarySearch(nums, 12);
        System.out.println(index);
    }
}
