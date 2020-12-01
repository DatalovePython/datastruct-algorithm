package newcode.math;

/**
 * @author luzc
 * @date 2020/10/20 11:24
 * @desc
 *
 *  从 1 到 n 整数中 1 出现的次数
 */
public class Math4 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}
