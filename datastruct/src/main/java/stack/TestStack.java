package stack;

import java.util.Stack;

/**
 * @author luzc
 * @date 2020/7/15 14:49
 * @desc
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        //in
        stack.add("jack");
        stack.add("jack2");
        stack.add("jack3");

        //out
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
}
