package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc1
 * @Author : Xulian
 * @Date : 2020/11/3 16:41
 */
public class lc1 {
    //O(nlogn) + O(n)
    public int[] twoSum(int[] nums, int target) {
        int[][] nums_new = new int[nums.length][2];
        for (int i = 0; i < nums_new.length; i++) {
            nums_new[i][0] = nums[i];
            nums_new[i][1] = i;
        }
        Arrays.sort(nums_new, Comparator.comparingInt(o -> o[0]));
        int left = 0, right = nums_new.length - 1;
        while (left < right){
            int res = nums_new[left][0] + nums_new[right][0];
            if (res == target){
                return new int[]{nums_new[left][1], nums_new[right][1]};
            }else if (res < target){
                left++;
            }else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
    //O(n) + O(n)
    //hash表的containsKey的时间复杂度是多少
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; ++i) {
//            if (hashtable.containsKey(target - nums[i])) {
//                return new int[]{hashtable.get(target - nums[i]), i};
//            }
//            hashtable.put(nums[i], i);
//        }
//        return new int[0];
//    }
}
