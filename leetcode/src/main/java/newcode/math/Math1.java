package newcode.math;

/**
 * @author luzc
 * @date 2020/10/20 10:12
 * @desc
 *
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 */
public class Math1 {
    public int NumberOf1(int n) {
        return Integer.bitCount(n);
    }
}
