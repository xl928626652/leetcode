package com.xl.msjd;

public class msjd0404 {
    boolean flag;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        flag = true;
        int left = recur(root.left);
        int right = recur(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return flag;
    }

    public int recur(TreeNode root) {
        //这里可以用！flag 来强行return，避免下一次递归
        if (root == null) return 0;
        int a = recur(root.left);
        int b = recur(root.right);
        if (Math.abs(a - b) > 1) {
            flag = false;
            return -2;
        }
        return Math.max(a, b) + 1;
    }
}
