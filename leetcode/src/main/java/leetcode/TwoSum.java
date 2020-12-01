package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */

public class TwoSum {

    //暴力破解
    public static  int[] twoSum(int[] nums,int target){
//        int result[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                int tmp = nums[i] + nums[j];
                if(tmp==target){
//                    result[0] = i;
//                    result[1] = j;
                    return new int[]{i,j};
//                    return result;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //巧用map
    public static int[] method2(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
       int nums[] = {2, 7, 11, 15};
       int target = 9;
       System.out.println((java.util.Arrays.toString(TwoSum.twoSum(nums,target))));
    }
}

