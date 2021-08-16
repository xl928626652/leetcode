package com.xl.jzoffer;

import java.util.ArrayList;
import java.util.List;

public class JZoffer_34 {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list_root=new ArrayList<>();
        recur(list_root,root,sum);
        return list;
    }
    public void recur(List<Integer> list, TreeNode root,int sum){
        if(root==null) return;
        List<Integer> new_list=new ArrayList<>(list);
        new_list.add(root.val);
        if(sum==root.val && root.left==null && root.right==null) {this.list.add(new_list);return;}
        recur(new_list,root.left,sum- root.val);
        recur(new_list,root.right,sum- root.val);
    }
}
