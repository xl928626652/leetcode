package com.xl.msjd;

public class msjd0406 {
    TreeNode tmp;
    int count;
    public void inOrder(TreeNode root, TreeNode p) {
        if (root == null || count >= 2) return;
        inOrder(root.left, p);
        if (count == 1) {
            tmp = root;
            count++;
        }
        if (root == p) {
            count++;
        }
        inOrder(root.right, p);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        tmp = null;
        count = 0;
        inOrder(root, p);
        return tmp;
    }
}
