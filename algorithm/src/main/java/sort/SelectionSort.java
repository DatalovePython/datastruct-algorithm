package sort;

import java.util.Arrays;

/**
 * @author luzc
 * @date 2020/9/23 16:03
 * @desc 选择排序,通过选取最小值
 *  选择排序和冒泡排序通过大0记法，都时O（N的平方），实质上差距很大
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 214, 51, 15};
        int[] ints = selectionSort(arr);
        System.out.println(Arrays.toString(ints));

    }

    private static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minElement = arr[i];
            int index = i;
            for (int j = i+1; j < arr.length-i-1; j++) {
                if(arr[j]<minElement){
                    minElement = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = minElement;
        }
        return arr;
    }
}
