package tree.bst;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 添加节点到二叉排序树的对应位置
     *
     * @param node 待插入的节点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //如果该节点的值大待插入节点的值
        if (value > node.value) {
            //如果该节点的左子树为空，就直接插入
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preTraverse() {
        System.out.println(this);
        if (left != null) {
            left.preTraverse();
        }
        if (right != null) {
            right.preTraverse();
        }
    }

    /**
     * 得到目标节点
     *
     * @param targetValue 目标节点的值
     * @return 目标节点
     */
    public Node getTargetNode(int targetValue) {
        //如果当前节点就是目标节点，就返回
        if (value == targetValue) {
            return this;
        }
        //如果当前节点的值大于目标节点，就向左查找，反之向右查找
        if (value > targetValue) {
            if (left == null) {
                return null;
            } else {
                return left.getTargetNode(targetValue);
            }
        } else {
            if (right == null) {
                return null;
            } else {
                return right.getTargetNode(targetValue);
            }
        }
    }

    /**
     * 得到目标节点的父节点
     *
     * @param targetValue 目标节点的值
     * @return 目标节点的父节点
     */
    public Node getParentNode(int targetValue) {
        //如果左右子树是目标节点，就返回该节点，否则继续向下查找
        if (left != null && left.value == targetValue) {
            return this;
        } else if (right != null && right.value == targetValue) {
            return this;
        } else {
            if (left != null && value > targetValue) {
                return left.getParentNode(targetValue);
            }
            if (right != null && value <= targetValue) {
                return right.getParentNode(targetValue);
            } else {
                //没有父节点（根节点）
                return null;
            }
        }
    }
}
