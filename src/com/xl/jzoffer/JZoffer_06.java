package com.xl.jzoffer;

import java.util.Arrays;

public class JZoffer_06 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        if(head==null) return new int[0];
        ListNode temp = new ListNode(head.val);
        temp.next=head.next;
        int len=1;
        while(head.next!=null)
        {
            head=head.next;
            len++;
        }
        int[] res=new int[len];
        res[len-1]=temp.val;
        len-=1;
        while(temp.next!=null)
        {
            len-=1;
            temp=temp.next;
            res[len]= temp.val;

        }
        return res;
    }
    //temp可以直接从head开始，节省代码量
    /*public int[] reversePrint(ListNode head) {
        if(head==null) return new int[0];
        ListNode temp = new ListNode(head.val);
        temp=head;
        int len=1;
        while(head.next!=null)
        {
            head=head.next;
            len++;
        }
        int[] res=new int[len];
        while(temp!=null)
        {
            res[--len]= temp.val;
            temp=temp.next;
        }
        return res;
    }*/

    public static void main(String[] args) {
        JZoffer_06 jZoffer_06 = new JZoffer_06();
        ListNode head=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        head.next=second;
        second.next=third;
        third.next=null;
        int[] test=jZoffer_06.reversePrint(head);
        int[] a=new int[5];
        a[0]=1;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(test));

    }
}
