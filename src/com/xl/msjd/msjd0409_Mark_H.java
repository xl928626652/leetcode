package com.xl.msjd;

import java.util.*;

public class msjd0409_Mark_H {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(root == null) {
            res.add(list);
            return res;
        }
        HashSet<TreeNode> set = new HashSet<>();
        set.add(root);
        dfs(set);
        return res;
    }

    void dfs(Set<TreeNode> curLevel){
        if(curLevel.size() == 0){
            res.add(new LinkedList<>(list));
            return;
        }
        Set<TreeNode> nextLevel = new HashSet<>();
        nextLevel.addAll(curLevel);
        for(TreeNode node : curLevel){
            nextLevel.remove(node); // 不能再访问这个结点
            if(node.left != null) nextLevel.add(node.left); // 把左右结点添加进去
            if(node.right != null) nextLevel.add(node.right);
            list.add(node.val); // 添加到链表中
            dfs(nextLevel); // 递归遍历下一层
            nextLevel.add(node); // 允许再次访问这个结点
            if(node.left != null) nextLevel.remove(node.left); // 清除新添加的结点
            if(node.right != null) nextLevel.remove(node.right);
            list.removeLast();
        }
    }

//    作者：BUAA-GKY
//    链接：https://leetcode-cn.com/problems/bst-sequences-lcci/solution/zhen-dtai-nan-liao-by-gao-kong-yuan/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
