package com.xl.msjd;

public class msjd0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count = 2;
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null || tempB != null) {
            if (count == 0) break;
            if (tempA == tempB) return tempA;
            if (tempA.next == null) {
                tempA = headB;
                count--;
            } else {
                tempA = tempA.next;
            }
            if (tempB.next == null) {
                tempB = headA;
                count--;
            } else {
                tempB = tempB.next;
            }
        }
        return null;
    }
}
