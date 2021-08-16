package com.xl.msjd;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1710 {
    //    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int len = nums.length;
//        for (int num : nums) {
//            int val = map.getOrDefault(num, 0);
//            if (val + 1 > len / 2) return num;
//            map.put(num, val + 1);
//        }
//        return -1;
//    }
    //摩尔投票法，在已知有众数的情况下，比较好用。
    //如果没有众数，需要再遍历一遍，看看是不是留下来的这个是众数
    //时间复杂度 O（n） 空间复杂度 O(1)
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        //先用摩尔投票算法找出候选答案
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count++ == 0) {
                res = nums[i];
                continue;
            }
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }
        //验证答案是否正确
        int countForce = (nums.length >> 1) + 1;
        count = 0;
        for (int val : nums) {
            if (val == res) count++;
        }
        return count >= countForce ? res : -1;
    }

    public static void main(String[] args) {
        int count = 0;
        System.out.println(count);
        if (count++ == 0) {
            System.out.println(count);
        }
        System.out.println(count);
    }
}
