package leetcode;

/**
 * @author luzc
 * @date 2021/1/24 15:11
 * @desc 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class LeetCode674 {

    private int findLengthOfLCIS(int[] nums) {
        // 边界判断
        if (nums.length <= 0) {
            return nums.length;
        }
        // 作为返回结果
        int result = 1;
        // 作为暂时保存最大长度的结果
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 符合条件，长度+1
                result++;
            } else {
                temp = Math.max(temp,result);
                // 长度重置
                result = 1;
            }
        }

        return Math.max(temp,result);
    }
}


