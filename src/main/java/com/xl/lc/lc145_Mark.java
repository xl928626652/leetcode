package com.xl.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc145_Mark {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return result;
        TreeNode preRoot = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //这一步最关键
            if (root.right == null || root.right == preRoot) {
                result.add(root.val);
                preRoot = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }
}
