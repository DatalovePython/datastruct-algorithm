package newcode.dfs;

/**
 * @author luzc
 * @date 2020/10/19 17:07
 * @desc 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * <p>
 * 思路：回溯+剪枝+迭代
 */
public class Dfs1 {

    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;
        //用于标记是否走过该路径
        boolean[][] marked = new boolean[rows][cols];
        // 先将一维数组转换为二维数组
        char[][] matrix = buildMatrix(array);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtracking(matrix, str, marked, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        //每次都是从0起步，如果能一直走到和str一样的长度，则可以返回true
        if (pathLen == str.length) {
            return true;
        }
        //当越界或者不匹配或者已经走过
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        marked[r][c] = true;
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

    // 先将一维数组转换为二维数组
    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = array[idx++];
            }
        }
        return matrix;
    }

}
