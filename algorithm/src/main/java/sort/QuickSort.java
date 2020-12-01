package sort;

import java.util.Arrays;

/**
 * @author luzc
 * @date 2020/9/25 15:36
 * @desc 快速排序
 * 分治算法的体现，运用到了迭代
 *
 * 1.选定pivot中心轴
 * 2.将大于pivot中心轴的放在右边
 * 3.将小于pivot中心轴的放在左边
 * 4.分别对左右子序重复1-3直至序列只有1个值
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 12, 214, 51, 15};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int L,int R){
        // 为迭代寻找一个出口
        if(L>=R)
            return ;

        int left = L;
        int right = R;
        int pivot = arr[left];
        while (left<right){
            while (left<right&&arr[right]>pivot){
                right--;
            }
            if(left<right){
                arr[left] = arr[right];
            }
            while (left<right&&arr[left]<=pivot){
                left++;
            }
            if(left<right){
                arr[right] = arr[left];
            }
            if(left>=right){
                arr[left]=pivot;
            }
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
