package com.xl.msjd;

public class msjd0408 {
    TreeNode treeNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        treeNode = root;
        boolean b = recur(root, p, q);
        return treeNode;
    }

    public boolean recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = recur(root.left, p, q);
        boolean right = recur(root.right, p, q);
        if ((root == p) || (root == q)) {
            if (left || right) {
                treeNode = root;
            }
            return true;
        } else {
            if (left && right) {
                treeNode = root;
            }
            return left || right;
        }
    }

}
