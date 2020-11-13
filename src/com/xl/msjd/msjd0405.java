package com.xl.msjd;

public class msjd0405 {
    boolean flag;
    long contrast;//这里需要用long，以防题目中有Integer.Min_VALUE 这种
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        flag = true;
        contrast = Long.MIN_VALUE;
        inOrder(root);
        return flag;
    }

    public void inOrder(TreeNode root) {
        if (root == null || !flag) return;
        inOrder(root.left);
        if (root.val <= contrast) {
            flag = false;
        }else{
            contrast = root.val;
        }
        inOrder(root.right);
    }
}
