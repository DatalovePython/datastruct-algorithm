package newcode.dfs;

/**
 * @author luzc
 * @date 2020/10/22 9:46
 * @desc 题意同Dfs1
 */

import java.util.*;

public class Dfs3 {
    private char[] mark;//标记是否走过
    private int[] dis = {0, 1, 0, -1, 0};
    private int row, col;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        mark = new char[matrix.length];
        row = rows;
        col = cols;
        for (int i = 0; i < mark.length; i++) {
            mark[i] = matrix[i];
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (Dfs(i, j, 0, str)) return true;
            }
        }
        return false;
    }

    private boolean Dfs(int r, int c, int index, char[] str) {
        if (r < 0 || r >= row || c < 0 || c >= col) return false;

        char ch = mark[col * r + c];
        //已经走过的不能再走；无论走没走过，都和str不匹配
        if (ch == '#' || ch != str[index]) {
            return false;
        }
        //下面的没有走过的，并且和str匹配

        if (index + 1 == str.length) return true;//最后一位匹配成功

        mark[col * r + c] = '#';
        for (int i = 0; i < 4; i++) {
            if (Dfs(r + dis[i], c + dis[i + 1], index + 1, str))
                return true;
        }

        //如果右下左上四步位移，都无法匹配str【index+1】，则回溯
        mark[col * r + c] = ch;
        return false;
    }


}
