package com.xl.msjd;

import java.util.HashSet;
import java.util.Set;

public class msjd0208 {
    public ListNode detectCycle(ListNode head) {
        ListNode tmp = head;
        Set<ListNode> set = new HashSet<>();
        while (tmp!=null){
            if(set.contains(tmp)) return tmp;
            set.add(tmp);
            tmp = tmp.next;
        }
        return null;
    }
}
