package newcode.recursive;

import newcode.easy.Solution1;

/**
 * @author luzc
 * @date 2020/10/19 14:17
 * @desc 求斐波那契数列的第 n 项，n <= 39。
 */
public class Recursive1 {
    private int[] fib = new int[40];

    public Recursive1() {
        fib[1] = 1;
        for (int i = 0; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

    }

    public int Fibonacci(int n) {
        return fib[n];
    }
}
