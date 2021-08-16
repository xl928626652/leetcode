package com.xl.jzoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class JZoffer_32_Mark {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        //这种思路可以
        Deque<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        /*Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(root);*/
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
