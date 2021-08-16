package com.xl.jzoffer;

public class JZoffer_24 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode pre=head, current=head.next;
        ListNode next=current.next;
        pre.next=null;
        while(current!=null){
            // pre.next=null;注意写的位置
            current.next=pre;
            pre=current;
            current=next;
            if(current!=null)
                next=next.next;
        }

        return pre;
    }
}
