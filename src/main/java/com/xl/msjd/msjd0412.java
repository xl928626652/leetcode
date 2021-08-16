package com.xl.msjd;

public class msjd0412 {
    int res;
    int sum;

    public int pathSum(TreeNode root, int sum) {
        res = 0;
        this.sum = sum;
        preOrder(root);
        return res;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        recur(root, 0);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void recur(TreeNode root, int num) {
        if (root == null) return;
        if (root.val + num == sum) {
            res++;
        }
        recur(root.left, num + root.val);
        recur(root.right, num + root.val);

    }
}
