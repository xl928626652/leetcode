package com.xl.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName : Maintest
 * @Author : Xulian
 * @Date : 2021/3/8 12:25
 */
public class Maintest {
    int num = 0;
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int[] visited;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        visited = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(list);
        return res;
    }

    void dfs(List<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            num++;
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            dfs(list);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    boolean[] vis;
    int num2 = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            num2++;
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }


    public static void main(String[] args) {
        Maintest maintest = new Maintest();
        maintest.permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        maintest.permuteUnique(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(maintest.num);
        System.out.println(maintest.num2);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }

}
