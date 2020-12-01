package node;

/**
 * @author luzc
 * @date 2020/10/13 19:12
 * @desc 单链表数据结构 格式为{0，1，2，3} ，每个链表代表一个数字
 * 从头到尾排布，通过 ‘，’ 分开
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
