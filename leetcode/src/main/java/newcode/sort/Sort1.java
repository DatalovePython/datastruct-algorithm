package newcode.sort;

import java.util.PriorityQueue;

/**
 * @author luzc
 * @date 2020/10/20 11:12
 * @desc 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Sort1 {

    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }


    //b站：舞年落梦解法

    //大小顶堆的元素个数差值不能超过1，取堆顶计算
    //中位数的区间，大顶堆来维护
    private PriorityQueue<Integer> queue1 = new PriorityQueue<>((o1, o2) -> (o1 - o2));

    //优先队列 默认就是小顶堆
    private PriorityQueue<Integer> queue2 = new PriorityQueue<>();

    //数据流中的个数
    private int sum = 0;


    //添加元素
    public void Insert2(Integer num) {
        if (sum % 2 == 0) {
            // 当两个堆的元素个数一样，此时新增一个元素，放入大顶堆（左区间）
            //queue1 里的元素一定大于等于queue2
            queue1.add(num);
        } else {
            queue2.add(num);
        }

        //此时满足大顶堆的堆顶一定大于小顶堆的堆顶
        if (!queue2.isEmpty() && queue1.peek() > queue2.peek()) {
            assert !queue1.isEmpty();
            int temp1 = queue1.poll();
            int temp2 = queue2.poll();
            queue1.add(temp2);
            queue2.add(temp1);
        }

        sum++;
    }

    public Double GetMedian2() {
        //如果奇数个，从queue中取堆顶元素就行
        if (sum % 2 == 1) {
            return (double) queue1.peek();
        } else {
            return (queue1.peek() + queue2.peek()) / 2.0;
        }
    }


}
