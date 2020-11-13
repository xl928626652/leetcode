package com.xl.jzoffer;


public class JZoffer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null) return null;
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        count -= k;
        while(count>0){
            head=head.next;
            count--;
        }
        return head;
    }
}
