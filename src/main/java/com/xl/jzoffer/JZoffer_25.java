package com.xl.jzoffer;

public class JZoffer_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        ListNode head=new ListNode(0);
        ListNode temp=head;
        while(l1 !=null && l2 !=null){
            if(l1.val< l2.val){
                temp.next=new ListNode(l1.val);
                temp=temp.next;
                l1=l1.next;
            }else{
                temp.next=new ListNode(l2.val);
                temp=temp.next;
                l2=l2.next;
            }
        }
        if(l1!=null)
        {
            temp.next=l1;
        }else{
            temp.next=l2;
        }


        return head.next;
    }
}
