package com.xl.msjd;

import java.util.List;

public class msjd0205_MarkMark {
    //这道题很搞
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) return null;
//        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
//        long res = 0L;
//        long count1 = 1L, count2 = 1L;
//        while (l1 != null) {
//            res += l1.val * count1;
//            count1 *= 10;
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            res += l2.val * count2;
//            count2 *= 10;
//            l2 = l2.next;
//        }
////        System.out.println("res" + ":" + res);
//        long yu = (res % 10);
////        System.out.println(yu);
////        System.out.println("yu" + ":" + yu);
//        String s = String.valueOf(yu);
//
//        ListNode head = new ListNode(Integer.parseInt(s));
//        ListNode tmp = head;
//        while (res / 10 != 0) {
//            res = res / 10;
//            s = String.valueOf(res % 10);
//            tmp.next = new ListNode(Integer.parseInt(s));
//            tmp = tmp.next;
//        }
//        return head;
//    }
    //很简洁的代码
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode sumList = new ListNode(0);
        ListNode tail = sumList;

        while(l1 != null || l2 != null){
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);

            add = s / 10;
            tail.next = new ListNode(s % 10);
            tail = tail.next;
        }
        if(add != 0)
            tail.next = new ListNode(add);
        return sumList.next;
    }
//
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(1);
//        ListNode tmp = l2;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        l2.next = new ListNode(9);
//        l2 = l2.next;
//        ListNode listNode = new msjd0205().addTwoNumbers(l1, tmp);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//
//        long l = 10000000000L;
//        System.out.println((int) l % 10);
//
//        long l3 = 22222222222L;
//        System.out.println((int) l3 % 10);
//        l3 /= 10;
//        System.out.println((int) l3 % 10);
//    }
}
