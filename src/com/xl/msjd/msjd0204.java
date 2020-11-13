package com.xl.msjd;

public class msjd0204 {
    /*思路：
    1.创建一个partitionNode节点，它的值是x
    2.创建一个头节点前的节点left，它的值是Integer.MIN_VALUE,并且让left节点指向partitionNode。
    3.遍历链表，把节点值小于x的节点接到left后面，把节点值大于等于x的节点接到partitionNode后面（这样子比x小的节点全部在x前面，大于等于x的节点都会在x后面，最后删掉left和partitionNode这两个辅助节点就可以了）
    4.删去partition节点，返回left.next节点即可。

    这题的限制其实不多，只要比x小的节点在x前面就可以，比x大的节点在x前面都没关系，所以你要是讨巧，把除了值等于x的节点全部放在x前面，其实都是可以的吧我猜。

    作者：xueluoxiaohan
    链接：https://leetcode-cn.com/problems/partition-list-lcci/solution/javashi-jian-100kong-jian-5-by-xueluoxiaohan/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;

        ListNode partitionNode = new ListNode(x);
        ListNode left = new ListNode(Integer.MIN_VALUE);
        left.next=partitionNode;
        ListNode tmp = head;
        while(tmp!=null){
            tmp=tmp.next;
            if(head.val< partitionNode.val){
                head.next=left.next;
                left.next=head;
            }else{
                head.next=partitionNode.next;
                partitionNode.next = head;
            }
            head=tmp;
        }
        tmp=left;
        while(tmp.next!=null){
            if(tmp.next.val==x){
                tmp.next=tmp.next.next;
                break;
            }
            tmp=tmp.next;
        }
        return left.next;
    }
}
