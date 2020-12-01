package newcode.tree;

import node.TreeNode;

/**
 * @author luzc
 * @date 2020/10/19 8:55
 * @desc 分别按照二叉树先序，中序和后序打印所有的节点。
 * <p>
 * 输入 ：{1,2,3}
 * 输出：[[1,2,3],[2,1,3],[2,3,1]]
 *
 * 1、先序遍历法：先访问根节点，再遍历左子树，最后遍历右子树；
 *
 * 2、中序遍历法：先遍历左子树，再访问根节点，最后遍历右子树；
 *
 * 3、后序遍历法：先遍历左子树，再遍历右子树，最后访问根节点。
 */
public class Tree1 {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    private int preIndex = 0, inIndex = 0, postIndex = 0;

    public int[][] threeOrders(TreeNode root) {
        int n = count(root);
        int[][] res = new int[3][n];
        orders(root, res);
        return res;
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public void orders(TreeNode root, int[][] res) {
        if (root == null) {
            return;
        }
        res[0][preIndex++] = root.val;
        orders(root.left, res);
        res[1][inIndex++] = root.val;
        orders(root.right, res);
        res[2][postIndex++] = root.val;
    }
}
