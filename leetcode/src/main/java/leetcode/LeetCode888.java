package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author luzc
 * @date 2021/2/1 14:46
 * @desc 交互给定的两个数组中的各自特定的值，使得交换后两个数组的值的总和大小相等
 */
public class LeetCode888 {

    public int[] fairCandySwap(int[] A, int[] B) {

        // 作为返回的结果
        int[] result = new int[2];
        // 两个数组的差值
        int diff = Arrays.stream(B).sum() - Arrays.stream(A).sum();

        // 数组A中的数值集合
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }

        // 找到两个数组的中元素的差值，其结果是两个数组和的差值的2倍
        for (int i : B) {
            if (set.contains(i - diff / 2)) {
                result[0] = i - diff / 2;
                result[1] = i;
                return result;
            }
        }
        return result;
    }
}
