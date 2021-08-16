package com.xl.lc;

/**
 * @ClassName : lc141
 * @Author : Xulian
 * @Date : 2020/10/10 15:49
 */
public class lc141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast==null){
                return false;
            }else {
                fast = fast.next;
            }
            if(slow == fast) return true;
        }
        return false;
    }
}
