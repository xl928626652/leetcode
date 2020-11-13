package com.xl.msjd;

import java.util.LinkedList;
import java.util.List;

public class msjd0804 {
    List<List<Integer>> lists;

    public List<List<Integer>> subsets(int[] nums) {
        lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            recur(i, nums, list);
        }
        return lists;
    }

    public void recur(int i, int[] nums, List<Integer> list) {
        if (list.contains(nums[i])) return;
        list.add(nums[i]);
        lists.add(new LinkedList<>(list));
        for (int j = i + 1; j < nums.length; j++) {
            recur(j, nums, list);
        }
        list.remove(list.size() - 1);
    }
}
