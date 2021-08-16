package com.xl.lc;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : lc147
 * @Author : Xulian
 * @Date : 2020/11/20 11:20
 */
public class lc147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.val));
        head = list.get(0);
        int index = 1;
        while (index < list.size()) {
            head.next = list.get(index++);
            head = head.next;
        }
        head.next = null;
        return list.get(0);
    }
}
