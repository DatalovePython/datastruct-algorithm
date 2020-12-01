package newcode.linkedlist;

import node.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author luzc
 * @date 2020/10/20 10:23
 * @desc
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class LinkedList3 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    /*
    * 解法一
    有时候当我们拿到一道题时，如果不能立马想到比较好的解决方案，不妨先用"笨"一点的方式去做一下，
    * "笨"的方案虽然效率不高，但是实现起来简单，也容易想到。为后面再做优化也起到了一个铺垫的效果。

    这里要求的是去重，那简单。用一个哈希表记录每个值出现的频率就可以了。
    具体做法如下:

    1.遍历链表，将每个节点的值放到哈希表中，哈希表的key就是节点的值，value是这个值出现的频率
    2.遍历哈希表，将所有频率==1的key放到集合中
    3.对集合进行排序
    4.遍历集合，然后不断创建新的链表节点
    5.当然这里可以优化一下，比如使用LinkedHashMap或者OrderedDict这样的数据结构，可以省去排序环节。

    * */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //用哈希表记录每个节点值的出现频率
        HashMap<Integer, Integer> cache = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            int val = p.val;
            if (cache.containsKey(val)) {
                cache.put(val, cache.get(val) + 1);
            } else {
                cache.put(val, 1);
            }
            p = p.next;
        }
        //将所有只出现一次的值放到arr中，之后再对这个arr排序
        for (Integer k : cache.keySet()) {
            if (cache.get(k) == 1) {
                arr.add(k);
            }
        }
        Collections.sort(arr);
        ListNode dummy = new ListNode(-1);
        p = dummy;
        //创建长度为arr.length长度的链表，依次将arr中的值赋给每个链表节点
        for (Integer i : arr) {
            ListNode tmp = new ListNode(i);
            p.next = tmp;
            p = p.next;
        }
        return dummy.next;
    }



}
