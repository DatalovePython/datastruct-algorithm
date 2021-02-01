package leetcode;

import java.util.Arrays;

/**
 * @author luzc
 * @date 2021/1/28 15:31
 * @desc 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 */

public class LeetCode724 {

    public int pivotIndex(int[] nums) {

        // 定义整个数组之和为sum
        int sum = Arrays.stream(nums).parallel().sum();
        // 定义前半部分数组之和
        int preSum = 0;


        for (int i = 0; i < nums.length; i++) {
            if (preSum == sum - nums[i] - preSum) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}
