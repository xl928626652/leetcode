package com.xl.msjd;

public class msjd0410 {
    boolean flag = false;

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        preOrder(t1,t2);
        return flag;
    }

    public void preOrder(TreeNode root,TreeNode t2){
        if(root == null || flag) return;
        if(root.val == t2.val){
            flag = recur(root,t2);
        }
        preOrder(root.left,t2);
        preOrder(root.right,t2);
    }
    public boolean recur(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if(t1.val == t2.val){
            return recur(t1.left,t2.left) && recur(t1.right,t2.right);
        }else{
            return false;
        }

    }

}
