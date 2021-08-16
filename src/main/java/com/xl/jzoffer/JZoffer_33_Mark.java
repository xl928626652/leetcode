package com.xl.jzoffer;

public class JZoffer_33_Mark {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
    //这种写法不好，主要是因为 应该用while，而不是for
    /*int[] po;
    HashMap<Integer,Integer> dic = new HashMap<>();
    public boolean verifyPostorder(int[] postorder) {
        po=postorder;
        for (int i = 0; i < postorder.length; i++) {
            dic.put(postorder[i],i);
        }
        return recur(postorder.length-1,0,postorder.length-2);
    }
    public boolean recur(int post_root, int in_left, int in_right){
        if(in_left>in_right+1) return false;
        int root_val = po[post_root];
        int split_point=post_root;
        int count=0;
        boolean flag_small=true;
        boolean flag_big=true;
        for (int i = in_left; i <in_right ; i++) {
            if(po[i]<root_val && po[i+1]>root_val){
                split_point=i;
                count++;
            }
            if(po[i]>root_val) flag_big=false;
            if(po[i]<root_val) flag_small=false;
        }
        if(count>1) return false;
        if(count==0 && ((flag_small || flag_big))) return true;
        boolean flag=recur(split_point,in_left,split_point-1) && recur(post_root-1,split_point+1,post_root-2);
        return flag;
    }*/

    public static void main(String[] args) {
        JZoffer_33_Mark jZoffer_33= new JZoffer_33_Mark();
        int[] postorder=new int[8];
        postorder[0]=1;
        postorder[1]=2;
        postorder[2]=5;
        postorder[3]=10;
        postorder[4]=6;
        postorder[5]=9;
        postorder[6]=4;
        postorder[7]=3;
        boolean flag= jZoffer_33.verifyPostorder(postorder);
        System.out.println(flag);

    }
}
