package sparsearray;

/**
 * @author luzc
 * @date 2020/7/10 14:18
 * @desc 稀疏数组，可以减少原来数组存储方式的空间。例如一个棋盘，如图
 * 用1代表黑，2代表白，0代表尚未落子。那么一开始0会占据很多数据空间。
 * 类似的还有地图类型
 */

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组，11*11
        // 1代表黑，2代表蓝子，0代表尚未落子。
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始数组为》》》》》》》");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组创建为稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //给洗漱数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存入sparseArray
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为》》》》》》》");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
            
        }

        //将稀疏数组恢复成二维数组
        //1.先读取第一行，制作一个二维数组
        int chessArray2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.遍历原有稀疏数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArray2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出新建二维数组
        System.out.println("重建原有数组为》》》》》》》");
        System.out.println();
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }



    }
}
