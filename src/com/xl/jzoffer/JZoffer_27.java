package com.xl.jzoffer;

public class JZoffer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        recur(root);
        return root;
    }
    public void recur(TreeNode root){
        if(root==null) return;
        //这个recur放在哪里都是一样的，这个挺重要的
        // recur(root.left);
        // recur(root.right);
        TreeNode temp= root.left;
        root.left=root.right;
        root.right=temp;
        recur(root.left);
        recur(root.right);

    }
}
