package com.xl.msjd;

public class msjd0203 {
    //这道题是真的服了
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
