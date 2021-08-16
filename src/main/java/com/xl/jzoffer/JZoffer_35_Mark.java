package com.xl.jzoffer;

import java.util.HashMap;

public class JZoffer_35_Mark {
    //hashmap 主要用来保存，值与index的固定关系的，比如之前用hashmap来保存中序遍历的数组的情况。
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        if(head==null) return null;
        Node cur=head;
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

}
