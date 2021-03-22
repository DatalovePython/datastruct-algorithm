package leetcode;

/**
 * @author luzc
 * @date 2021/2/2 15:19
 * @desc 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 10000。
 * <p>
 * 思路 ：双指针
 */
public class LeetCode424 {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int i = characterReplacement(s, k);

    }

    public static int characterReplacement(String s, int k) {
        // 左指针
        int left = 0;
        // 右指针
        int right = 0;
        // 返回结果
        int result = 0;
        // 左右指针内最多的字符长度
        int maxLen = -1;
        // 字母出现次数的计数器
        char[] charNums = new char[256];
        while (right < s.length()) {
            char cur = s.charAt(right);
            charNums[cur]++;
            maxLen = Math.max(maxLen, charNums[cur]);
            // right - left + 1 窗口长度
            while ((right - left + 1 - maxLen) > k) {
                charNums[s.charAt(left++)]--;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
