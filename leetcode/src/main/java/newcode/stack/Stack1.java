package newcode.stack;

import java.util.Stack;

/**
 * @author luzc
 * @date 2020/10/20 10:53
 * @desc
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 */
public class Stack1 {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
