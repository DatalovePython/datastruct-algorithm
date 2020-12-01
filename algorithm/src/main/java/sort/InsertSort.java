package sort;

import java.util.Arrays;

/**
 * @author luzc
 * @date 2020/9/25 11:29
 * @desc 插入排序
 *  通过先前比较，能把已经比较过的有序排列，避免无用比较
 *  相比冒泡和选择，在均匀分布的情况下，
 *  排序效率大大提升
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 214, 51, 15};
        int[] ints = insertSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] insertSort(int[] arr){
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }
}
