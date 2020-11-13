package com.xl.lc;

public class lc328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddFirst = head;
        if (oddFirst == null) return null;
        ListNode evenFirst = oddFirst.next;
        ListNode evenHead = evenFirst;
        while (evenFirst != null) {
            ListNode tmp = evenFirst.next;
            if (tmp != null) {
                evenFirst.next = tmp.next;
                oddFirst.next = tmp;
                oddFirst = oddFirst.next;
                evenFirst = evenFirst.next;
            } else {
                break;
            }
        }
        oddFirst.next = evenHead;
        return head;
    }
}
