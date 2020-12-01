package newcode.tree;

import node.TreeNode;

/**
 * @author luzc
 * @date 2020/10/20 13:46
 * @desc 二叉查找树的第 K 个结点
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * <p>
 * 二叉搜索树 进行 中序遍历
 * 得到的结果一定是一个单调递增序列
 */
public class Tree13 {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        cnt++;
        if (cnt == k)
            ret = root;
        inOrder(root.right, k);
    }

    //b站：舞年落梦解法
    //返回的结果
    private TreeNode ans;
    //中序遍历的序列
    private int index;

    public TreeNode KthNode2(TreeNode pRoot, int k) {
        index = 1;
        ans = null;
        if (k == 0 && pRoot == null) {
            solve(pRoot, k);
        }
        return ans;
    }

    private void solve(TreeNode node, int k) {
        //实现中序编列
        // 剪枝操作
        if (ans == null) {
            if (node.left != null) {
                solve(node.left, k);
            }

            if (index == k) {
                ans = node;
            }

            index++;

            if (node.right != null) {
                solve(node.right, k);
            }
        }
    }


}
