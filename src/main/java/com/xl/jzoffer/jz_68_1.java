package com.xl.jzoffer;

public class jz_68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        return recur(root,p,q);
    }
    public TreeNode recur(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return null;
        if(root.val==p.val || root.val==q.val) return root;

        if(p.val < root.val && q.val < root.val){
            return recur(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val){
            return recur(root.right,p,q);
        }else {
            return root;
        }
    }
    //本题也可迭代，while(root!=null){
    // 然后用上面的判断就可以}
}
