package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class ThreadedBinaryTree {
    private SubStudent root;
    /**
     * 指向当前节点的前一个节点
     */
    private SubStudent pre;

    public void setRoot(SubStudent root) {
        this.root = root;
    }

    /**
     * 中序线索化
     *
     * @param node 当前节点
     */
    private void midThreaded(SubStudent node) {
        if (node == null) {
            return;
        }
        //左线索化
        midThreaded(node.getLeft());

        //线索化当前节点
        //如果当前节点的左指针为空，就指向前驱节点，并改变左指针类型
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //通过前驱节点来将右指针的值令为后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        //处理一个节点后，让当前节点变为下一个节点的前驱节点
        pre = node;

        //右线索化
        midThreaded(node.getRight());
    }

    public void midThreaded() {
        midThreaded(root);
    }

    /**
     * 遍历线索化后的二叉树
     */
    public void midThreadedTraverse() {
        //暂存遍历到的节点
        SubStudent tempNode = root;
        //非递归的方法遍历，如果tempNode不为空就一直循环
        while (tempNode != null) {
            //一直访问二叉树的左子树，直到某个节点的左子树指向前驱节点
            while (tempNode.getLeftType() != 1) {
                tempNode = tempNode.getLeft();
            }
            //找到了第一个节点
            System.out.println(tempNode);
            //再访问该节点的右子树，看是否保存了后继节点
            //如果是，则打印该节点的后继节点信息
            while (tempNode.getRightType() == 1) {
                tempNode = tempNode.getRight();
                System.out.println(tempNode);
            }

            tempNode = tempNode.getRight();
        }

    }
}
