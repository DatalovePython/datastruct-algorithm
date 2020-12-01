package sort;

import java.util.Arrays;

/**
 * @author luzc
 * @date 2020/9/14 11:19
 * @desc 冒泡排序的实现
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 214, 51, 15};
        int[] ints = bubbleSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    // 自创解法
    public static int[] bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int start = 0;
            int next = 1;
            for (int j = 1; j < length - i; j++) {
                if (arr[start] > arr[next]) {
                    int temp = arr[next];
                    arr[next] = arr[start];
                    arr[start] = temp;
                }
                start++;
                next++;
            }
        }
        return arr;
    }

    //参考解法
    public static int[] bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - i - 1; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


}
