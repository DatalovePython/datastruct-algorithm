package newcode.tree;

/**
 * @author luzc
 * @date 2020/10/22 18:02
 * @desc
 */


import java.util.LinkedList;




public class TreeSearch {

    //节点数据结构
    class TreeNode {

        String value = null;
        TreeNode leftchildren = null;
        TreeNode rightchildre = null;

        public TreeNode(String value, TreeNode leftchildren, TreeNode rightchildre) {
            this.value = value;
            this.leftchildren = leftchildren;
            this.rightchildre = rightchildre;
        }

        public TreeNode(String value) {
            this.value = value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setLeftchildren(TreeNode leftchildren) {
            this.leftchildren = leftchildren;
        }

        public void setRightchildre(TreeNode rightchildre) {
            this.rightchildre = rightchildre;
        }

        public String getValue() {
            return value;
        }

        public TreeNode getLeftchildren() {
            return leftchildren;
        }

        public TreeNode getRightchildre() {
            return rightchildre;
        }
    }

    public TreeNode getTargetTree() {
        // 叶子节点
        TreeNode G = new TreeNode("G");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E", G, null);
        TreeNode B = new TreeNode("B", D, E);
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode F = new TreeNode("F", H, I);
        TreeNode C = new TreeNode("C", null, F);
        // 构造根节点
        TreeNode root = new TreeNode("A", B, C);
        return root;
    }

    /**
     * 前序遍历
     */
    public void preorderVistTreeNode(TreeNode node) {
        if (null != node) {

            System.out.print(node.value);

            if (null != node.leftchildren) {
                preorderVistTreeNode(node.leftchildren);
            }
            if (null != node.rightchildre) {
                preorderVistTreeNode(node.rightchildre);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inorderVistTreeNode(TreeNode node) {
        if (null != node) {
            if (null != node.leftchildren) {
                inorderVistTreeNode(node.leftchildren);
            }

            System.out.print(node.value);

            if (null != node.rightchildre) {
                inorderVistTreeNode(node.rightchildre);
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postorderVistTreeNode(TreeNode node) {
        if (null != node) {
            if (null != node.leftchildren) {
                postorderVistTreeNode(node.leftchildren);
            }
            if (null != node.rightchildre) {
                postorderVistTreeNode(node.rightchildre);
            }

            System.out.print(node.value);
        }
    }

    /**
     * 层次遍历
     */
    public void levelorderVistTreeNode(TreeNode node) {
        if (null != node) {
            LinkedList<TreeNode> list = new LinkedList<TreeNode>();
            list.add(node);
            TreeNode currentNode;
            while (!list.isEmpty()) {

                currentNode = list.poll();

                System.out.print(currentNode.value);

                if (null != currentNode.leftchildren) {
                    list.add(currentNode.leftchildren);
                }
                if (null != currentNode.rightchildre) {
                    list.add(currentNode.rightchildre);
                }
            }
        }
    }

    public static void main(String[] args) {

        TreeSearch treeSearch = new TreeSearch();
        TreeNode tree = treeSearch.getTargetTree();

        System.out.print("前序遍历:");
        treeSearch.preorderVistTreeNode(tree);
        System.out.println("");

        System.out.print("中序遍历:");
        treeSearch.inorderVistTreeNode(tree);
        System.out.println("");

        System.out.print("后序遍历:");
        treeSearch.postorderVistTreeNode(tree);
        System.out.println("");

        System.out.print("层次遍历:");
        treeSearch.levelorderVistTreeNode(tree);
    }
}
