package com.xl.jzoffer;

public class jz_54 {
    int count=0;
    int res=0;
    public int kthLargest(TreeNode root, int k) {
        if(root==null) return 0;
        res=root.val;
        postOrder(root,k);
        return res;
    }
    public void postOrder(TreeNode root, int k){
        if(root==null) return;
        postOrder(root.right,k);
        if(++count==k){
            res=root.val;
        }
        postOrder(root.left,k);
    }
}
