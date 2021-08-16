package com.xl.lc;

/**
 * @ClassName : lc21
 * @Author : Xulian
 * @Date : 2020/11/21 17:02
 */
public class lc21_Mark {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) tmp.next = l1;
        else {
            tmp.next = l2;
        }
        return dummy.next;
    }

}
