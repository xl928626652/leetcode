package com.xl.lc;

/**
 * @ClassName : lc142
 * @Author : Xulian
 * @Date : 2020/10/10 16:01
 */
public class lc142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast==null){
                return null;
            }else {
                fast = fast.next;
            }
            if(slow == fast) break;
        }
        if(fast == null || slow == null) return null;
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
