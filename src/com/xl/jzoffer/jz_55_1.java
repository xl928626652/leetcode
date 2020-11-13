package com.xl.jzoffer;

import java.util.Map;

public class jz_55_1 {
    // 这是用来传depth的方法，可以试试recur不返回的方法。
    /*public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return recur(root, 0);
    }

    public int recur(TreeNode root, int depth) {
        if (root == null) return depth;
        depth++;
        return Math.max(recur(root.left, depth), recur(root.right, depth));
    }*/

    //这个方法不用return
    int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return depth;
        recur(root, 0);
        return depth;
    }

    public void recur(TreeNode root, int d) {
        if (root == null) return;
        depth = Math.max(depth, ++d);
        recur(root.left, d);
        recur(root.right, d);
    }

}
