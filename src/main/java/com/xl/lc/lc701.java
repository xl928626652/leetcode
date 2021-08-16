package com.xl.lc;

import java.util.List;

/**
 * @ClassName : lc701
 * @Author : Xulian
 * @Date : 2020/9/30 9:55
 */
public class lc701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode preRoot = null;
        TreeNode p = root;
        while (p != null) {
            preRoot = p;
            if (p.val < val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (preRoot.val < val) {
            preRoot.right = new TreeNode(val);
        } else {
            preRoot.left = new TreeNode(val);
        }
        return root;
    }

}
