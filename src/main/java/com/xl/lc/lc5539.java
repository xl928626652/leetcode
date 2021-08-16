package com.xl.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : lc5539
 * @Author : Xulian
 * @Date : 2020/11/1 15:12
 */
public class lc5539 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer[] nums_new = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_new[i] = nums[i];
        }
        Arrays.sort(nums_new, (o1, o2) -> map.get(o1) == map.get(o2) ? o2 - o1 : map.get(o1) - map.get(o2));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums_new[i];
        }
        return nums;
    }
}
