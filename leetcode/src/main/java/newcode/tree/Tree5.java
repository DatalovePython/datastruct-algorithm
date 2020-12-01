package newcode.tree;

import node.TreeNode;

/**
 * @author luzc
 * @date 2020/10/20 10:45
 * @desc
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Tree5 {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
