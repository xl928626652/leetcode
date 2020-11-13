package com.xl.jzoffer;

import com.xl.base.PreInPostOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jz_68_2 {
    List<Integer> listP = new ArrayList<>();
    List<Integer> listQ = new ArrayList<>();

    boolean flagP = false;
    boolean flagQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        List<Integer> list_P = new ArrayList<>();
        List<Integer> list_Q = new ArrayList<>();

        recur(root, p, list_P, "p");
        recur(root, q, list_Q, "q");
        //运行到这里的时候，listP和listQ里面的信息分别代表了P节点和Q节点在二叉树中的路径。
        int index = 0;
        int len = Math.min(this.listP.size(), this.listQ.size()); //
        if (len == 0) return root; //如果listP或者listQ有长度为0的,代表root节点就是最小父节点
        while (index < len && this.listP.get(index).equals(this.listQ.get(index))) {//index < len 要放在判断语句的最前面，否则listP.get会越界
            root = this.listP.get(index++) == 0 ? root.left : root.right;
        }
        return root;
    }

    public void recur(TreeNode root, TreeNode p, List<Integer> list, String s) {
        if (root == null) return;

        if(s.equals("p") && flagP) return;//剪枝操作，虽然感觉速度没快多少
        if(s.equals("q") && flagQ) return;

        if (root.val == p.val && s.equals("p")) {
            this.listP = new ArrayList<>(list);
            flagP = true;
            return;
        }
        if (root.val == p.val && s.equals("q")) {
            this.listQ = new ArrayList<>(list);
            flagQ = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                list.add(0);//回溯的解法
                recur(root.left, p, list, s);
                list.remove(list.size() - 1);
            } else {
                list.add(1);
                recur(root.right, p, list, s);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
