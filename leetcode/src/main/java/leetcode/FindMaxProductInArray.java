package leetcode;

import java.util.Arrays;

/**
 * @author luzc
 * @date 2021/1/20 15:01
 * @desc 整型数组中寻找最大3个数值的乘积并输出
 */


public class FindMaxProductInArray {


    /**
     * @param array 整型数组
     * @return 返回最大乘积
     */
    private Integer fun(int[] array) {
        if (array.length < 3) {
            return null;
        }
        if (array.length == 3) {
            return array[0] * array[1] * array[2];
        }

        // 此时数组从小达到排列
        Arrays.sort(array);

        // 如果全是正数或只有一个负数或全是负数，则最大积为三个最大的数相乘
        // 如果有一个以上的负数，则可以比较最小的两个负数与最大的数的乘积，与三个最大的数相乘的大小
        return Integer.max(array[-1] * array[-2] * array[-3],
                array[-1] * array[0] * array[1]);


    }


}
