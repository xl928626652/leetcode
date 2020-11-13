package com.xl.msjd;

public class msjd0202 {
    //所谓的快慢指针
    public int kthToLast(ListNode head, int k) {
        ListNode tail=head;
        while(k>1){
            tail=tail.next;
            k--;
        }
        while(tail.next!=null){
            head=head.next;
            tail=tail.next;
        }
        return head.val;
    }
}
