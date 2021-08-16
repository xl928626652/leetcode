package com.xl.msjd;

import java.util.ArrayList;
import java.util.List;

public class msjd0206 {
    //时间空间太慢
//    public boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        ListNode tmp = head;
//        while (tmp != null) {
//            list.add(tmp.val);
//            tmp = tmp.next;
//        }
//        tmp = head;
//        for (int i = list.size() - 1; i > -1; i--) {
//            if (list.get(i) != tmp.val) return false;
//            tmp = tmp.next;
//        }
//        return true;
//    }
    //时间O（n）、空间O（1）
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        if (length == 1) return true;
        if (length == 2) return head.val == head.next.val;

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        pre.next = null;

        for (int i = 1; i < length / 2; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        if (length % 2 != 0) cur = next;
        while (pre != null && cur != null) {
            if (pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
}
