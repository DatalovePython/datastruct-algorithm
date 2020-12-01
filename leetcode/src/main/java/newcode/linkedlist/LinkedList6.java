package newcode.linkedlist;

import node.ListNode;

/**
 * @author luzc
 * @date 2020/10/20 10:39
 * @desc
 *
 * 反转链表
 */
public class LinkedList6 {

    //递归
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList1(next);
        next.next = head;
        return newHead;
    }

    //迭代
    public ListNode ReverseList2(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }
}
