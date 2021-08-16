package com.xl.msjd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class msjd0403_Mark {
    //自己写的代码又臭又长
//    public ListNode[] listOfDepth(TreeNode tree) {
//        if(tree == null) return null;
//        List<ListNode> listNodeList = new LinkedList<>();
//        List<TreeNode> list = new LinkedList<>();
//        list.add(tree);
//        while (!list.isEmpty()){
//            TreeNode p = list.remove(0);
//            ListNode root = new ListNode(p.val);
//            ListNode q = root;
//            int len =list.size();
//            for (int i = 0; i < len; i++) {
//                q.next = new ListNode(list.get(i).val);
//                q=q.next;
//            }
//            listNodeList.add(root);
//            if(p.left!=null){
//                list.add(p.left);
//            }
//            if(p.right!=null){
//                list.add(p.right);
//            }
//            for (int i = 0; i < len; i++) {
//                p=list.remove(0);
//                if(p.left!=null){
//                    list.add(p.left);
//                }
//                if(p.right!=null){
//                    list.add(p.right);
//                }
//            }
//
//        }
//        ListNode[] res =new ListNode[listNodeList.size()];
//        int index = 0;
//        for (ListNode listNode: listNodeList){
//            res[index++]=listNode;
//        }
//        return res;
//    }
    public ListNode[] listOfDepth(TreeNode tree) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode curr = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                curr.next = new ListNode(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                curr = curr.next;
            }
            res.add(dummy.next);
            dummy.next = null;
        }

        return res.toArray(new ListNode[]{});
    }

//    作者：fisher12
//    链接：https://leetcode-cn.com/problems/list-of-depth-lcci/solution/ceng-xu-bian-li-by-fisher12/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
