package tree.avl;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class AVLTree {
    private Node root;


    public void addNode(Node node) {
        //如果根节点为空，就直接将该节点作为根节点
        if (root == null) {
            root = node;
            return;
        }
        //否则就插入该节点到对应的位置
        root.add(node);
    }

    public void preTraverse() {
        if (root == null) {
            System.out.println("二叉树为空");
        } else {
            root.preTraverse();
        }
    }

    /**
     * 找到以node为根节点的二叉树的最小节点的值
     *
     * @param node 作为根节点的节点
     * @return 值最小的节点的值
     */
    public int getMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        //返回值最小的节点
        return node.value;
    }

    public int getDifference() {
        int leftHeight = root.getLeftHeight();
        int rightHeight = root.getRightHeight();
        //返回左右子树高度差值
        return Math.abs(leftHeight - rightHeight);
    }
}
