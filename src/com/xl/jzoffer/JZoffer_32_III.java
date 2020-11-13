package com.xl.jzoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class JZoffer_32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        int index=0;
        Deque<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            //这里的index++其实就是判断完了最后++，写在这里只是为了减少代码量
            if(index++%2!=0){
                List<Integer> new_ans = new ArrayList<>();
                for(int i=ans.size()-1;i>-1;i--){
                    new_ans.add(ans.get(i));
                }
                list.add(new_ans);
            }else{
                list.add(ans);
            }

        }
        return list;
    }
}
