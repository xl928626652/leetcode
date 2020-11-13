package com.xl.lc;

import java.util.ArrayList;
import java.util.List;

public class lc_46 {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        int[] visited = new int[nums.length];
        List<Integer> list=new ArrayList<>();
        dfs(visited,list);
        return res;
    }

    void dfs(int[] visited, List<Integer> list){
        if(list.size()== nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]==1){
                continue;
            }
            visited[i]=1;
            list.add(nums[i]);
            dfs(visited,list);
            visited[i]=0;
            list.remove(list.size()-1);
        }
    }
}
