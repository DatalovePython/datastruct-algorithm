package duplicate;

/**
 * @author luzc
 * @date 2020/9/23 14:16
 * @desc 检查数组中是否有重复元素
 */
public class HasDuplicateValue {


    public static void main(String[] args) {
        int[] arr = {1, 12, 214, 51, 15, 1};

    }

    //双层for循环，暴力解决
    private static boolean hasDuplicateValue(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int target = arr[i];
            for (int a : arr) {
                if (target == a) {
                    return true;
                }
            }
        }
        return false;
    }

    //双层for更加简洁
    private static boolean hasDuplicateValue1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int i1 = 0; i1 < length; i1++) {
                if (i != i1 && arr[i]==arr[i1]){
                    return true;
                }
            }
        }
        return false;
    }

    // 线性解决,利用另外一个数组，查找只要一步的特性。快速实现
    private static boolean hasDuplicateValue2(int[] arr){
        int[] existingNumbers = {};
        for (int i = 0; i < arr.length; i++) {
            if(existingNumbers[arr[i]] ==0){
                existingNumbers[arr[i]] = 1;
            }else {
                return true;
            }
        }
        return false;
    }


}
