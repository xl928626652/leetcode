package com.xl.jzoffer;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class JZoffer_18 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp=head;
        if(head.val==val)
            return head.next;
        while(temp.next!=null)
        {
            if(temp.next.val==val)
                temp.next=temp.next.next;
            if(temp.next!=null)//这一行很关键
                temp=temp.next;
        }
        return head;
    }
}
