package newcode.easy;

import node.ListNode;

/*
输入一个链表，反转链表后，输出新链表的表头。

* */
public class Solution2 {
    public ListNode ReverseList(ListNode head) {
        if (head ==null || head.next==null){
            return head;
        }else {
            ListNode pre = null;
            ListNode next = null;
            while (head!=null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
}