package newcode.tree;

import node.TreeNode;

/**
 * @author luzc
 * @date 2020/10/20 13:46
 * @desc
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 */
public class Tree14 {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
