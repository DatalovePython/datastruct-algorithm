package leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */

public class EasyIntReverse {

    public int reverse(int x) {
        boolean flag = true;
        if(x < 0) {
            x = -x;
            flag = false;
        }
        if(x == 0) {
            return 0;
        }
        while(x % 10 == 0) {
            x /= 10;
        }
        long result = 0;
        while(x > 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        if(flag) {
            return (int)result;
        }else {
            return -(int)result;
        }
    }
}
