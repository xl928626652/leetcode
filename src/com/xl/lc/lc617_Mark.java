package com.xl.lc;

import com.xl.base.PreInPostOrder;

import java.util.Deque;
import java.util.LinkedList;

public class lc617_Mark {
    //这道题是一个递归的很好的例子，这其实是根左右，前序遍历
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode newRoot = new TreeNode(t1.val+ t2.val);
        newRoot.left = mergeTrees(t1.left,t2.left);
        newRoot.right = mergeTrees(t1.right,t2.right);
        return newRoot;
    }


}
