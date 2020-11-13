package com.xl.jzoffer;

public class jz_55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        recur(root, 0);
        return aBoolean;
    }

    boolean aBoolean = true;

    public int recur(TreeNode root, int depth) {
        if (root == null) return depth;
        depth++;
        int leftD = recur(root.left, depth), rightD = recur(root.right, depth);
        if (Math.abs(leftD - rightD) > 1) {
            aBoolean = false;
            return 0;
        }
        return Math.max(recur(root.left, depth), recur(root.right, depth));
    }
}
