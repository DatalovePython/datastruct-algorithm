package newcode.linkedlist;

import node.ListNode;

/**
 * @author luzc
 * @date 2020/10/20 10:21
 * @desc 在 O(1) 时间内删除链表节点
 * <p>
 * ① 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
 * ② 否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
 * <p>
 * 综上，如果进行 N 次操作，那么大约需要操作节点的次数为 N-1+N=2N-1，
 * 其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1) 的时间复杂度操作节点的总次数，
 * N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。(2N-1)/N ~ 2，因此该算法的平均时间复杂度为 O(1)。
 * <p>
 * <p>
 * 打破了原有堆链表的认识，我原来将链表一直当Python中的数组在用。
 * 1：删除单向链表的两种思想
 * 通过遍历，暴力匹配，匹配完成后将当前指针指向下一个节点。
 * 2：通过双指针
 * pre 指向 after
 */
public class LinkedList2 {

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            if (head == tobeDelete)
                // 只有一个节点
                head = null;
            else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }


    // 通过改变指向删除节点
    public ListNode deleteNode2(ListNode head, int val) {
        // 空链表
        if (head == null) {
            return null;
        }
        // 至少有一个节点
        boolean find = false;   // false表示没找到val，true表示找到了
        // 新增头节点
        ListNode phead = new ListNode(-1);
        phead.next = head;
        // slow指向要删除的节点的前驱，quick指向要删除的节点
        ListNode slow = phead, quick = phead.next;
        while (quick != null) {
            if (quick.val == val) {     // 找到了
                find = true;
                break;
            }
            slow = slow.next;
            quick = quick.next;
        }
        // 如果没找到就不用删，返回原链表
        if (!find) {
            return head;
        }
        // 找到了要删，改变前驱指向即可
        slow.next = quick.next;
        return phead.next;

    }

    //为什么啥都能用递归啊，牛逼！！！
    /*public void recursion(参数0) {
    if (终止条件) {
        return;
    }

    可能有一些逻辑运算
    recursion(参数1)
    可能有一些逻辑运算
    recursion(参数2)
            ……
    recursion(参数n)
    可能有一些逻辑运算
}

    * */
    public ListNode deleteNode3(ListNode head, int val) {
        if (head == null)
            return head;
        if (head.val == val)
            return head.next;
        head.next = deleteNode3(head.next, val);
        return head;
    }


}
