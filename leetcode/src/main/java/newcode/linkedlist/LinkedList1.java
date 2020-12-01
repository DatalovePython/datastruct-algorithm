package newcode.linkedlist;

import node.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author luzc
 * @date 2020/10/19 10:22
 * @desc 从尾到头反过来打印出每个结点的值。
 * <p>
 * 如果是双向链表好做，从后往前就行了
 * 主要考察单向链表如何反转打印。
 * 简单说，单向链表，你如何反转？有哪几个解决方法？哪个方法效率最高。
 */
public class LinkedList1 {

    // 使用递归的特性，递归有深度搜索的特性。一层一层往下，直到终止条件，然后又能一层一层回去
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead1(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //使用头插法
    // 头插法：每次将最新的 值插在最前方
    // 头插法：每次将最新的 值插在最后方
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        //头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }

        //构建ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    //使用栈,最简单，好理解。
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }



}
