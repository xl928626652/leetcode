package com.xl.jzoffer;

public class jz_52 {
    //很巧妙的方法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        if (tempA == null || tempB == null) return null;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
