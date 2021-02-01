package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzc
 * @date 2021/1/22 16:56
 * @desc 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> resultList = new ArrayList<>();

        // 先边界判断
        if (A.length == 0) {
            return resultList;
        }

        // 数值转换并计算 A K 之和
        StringBuilder count = new StringBuilder();

        for (int i : A) {
            count.append(i);
        }

        int sumResult = Integer.parseInt(count.toString()) + K;

        // 类型转换 String -> List
        String temp = String.valueOf(sumResult);

        for (int i = 0; i < temp.length(); i++) {
            resultList.add((int) temp.charAt(i));
        }

        return resultList;
    }
}
