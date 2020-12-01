package newcode.string;

import java.util.BitSet;

/**
 * @author luzc
 * @date 2020/10/20 11:30
 * @desc
 *
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 *
 * Input: abacc
 * Output: b.
 *
 * 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，
 * 因此可以使用整型数组代替 HashMap，从而将空间复杂度由 O(N) 降低为 O(1)。
 *
 * 以上实现的空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，
 * 那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
 */
public class String8 {

    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c);     // 0 0 -> 0 1
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);     // 0 1 -> 1 1
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))  // 0 1
                return i;
        }
        return -1;
    }


}
