package com.xl.jzoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class JZoffer_32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
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
            list.add(ans);
        }
        return list;
    }
}
