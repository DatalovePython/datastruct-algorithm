package newcode.list;

/**
 * @author luzc
 * @date 2020/10/20 13:47
 * @desc
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 */
public class List10 {

    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
}
