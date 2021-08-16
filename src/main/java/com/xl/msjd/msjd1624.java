package com.xl.msjd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1624 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int left = 0, right = nums.length-1;
        while (left < right){
            if(nums[left]+nums[right] == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                lists.add(new ArrayList<>(list));
                left++;
                right--;
            }else if(nums[left]+nums[right]>target){
                right--;
            }else if(nums[left]+nums[right]<target){
                left++;
            }
        }
        return lists;
    }
}
