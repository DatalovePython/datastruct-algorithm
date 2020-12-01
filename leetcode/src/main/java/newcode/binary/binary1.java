package newcode.binary;

/**
 * @author luzc
 * @date 2020/10/19 14:49
 * @desc 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * <p>
 * 运用二分法，基本会有两个指针
 */
public class binary1 {
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            //取中间值，确定指针的移动
            int m = (l + h) / 2;
            //如果数组元素允许重复，会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，
            // 此时无法确定解在哪个区间，需要切换到顺序查找。例如对于数组 {1,1,1,0,1}，
            // l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。

            //举例 ｛3,4,5,1,2｝
            //此处 nums[h] = 2,nums[l] = 3,nums[m]=5
            if (nums[l] == nums[m] && nums[m] == nums[h])
                return minNumber(nums, l, h);
            else if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }
}
