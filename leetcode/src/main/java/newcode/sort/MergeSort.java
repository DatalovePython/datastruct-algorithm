package newcode.sort;

/**
 * @author luzc
 * @date 2020/10/26 8:55
 * @desc 归并排序
 * <p>
 * 时间复杂度：O（nlogn)
 * 空间复杂度：
 * 是否稳定：稳定
 */

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1, 11, 2, 3, 5, 68, 0, 1};
        System.out.println("未排序的数组：" + Arrays.toString(a));
        if (a.length > 0) {
            mergeSort(a, 0, a.length - 1);
        } else {
            System.out.println("空数组不能排序");
        }
        System.out.println("排序后的数组：" + Arrays.toString(a));
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] mergeArr = new int[high - low + 1];//申请一个新空间来保存排序后数组
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                mergeArr[k] = a[i];
                k++;
                i++;
            } else {
                mergeArr[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            mergeArr[k] = a[i];
            k++;
            i++;
        }//把左边剩余的元素导入
        while (j <= high) {
            mergeArr[k] = a[j];
            j++;
            k++;
        }//把右边剩余的元素导入
        for (int m = 0; m < mergeArr.length; m++) {
            a[m + low] = mergeArr[m];
        }//将新排好序的数组放入元素相应的位置中
    }

    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);//左
            mergeSort(a, mid + 1, high);//右
            merge(a, low, mid, high);//左右合并
        }
    }
}
