package tree.avl;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
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

        //如果右子树高度与左子树高度差值大于一，就进行左旋转
        if (getRightHeight() - getLeftHeight() > 1) {
            //如果当前节点右子树的左子树高度高于右子树，其右子树先进行右旋转
            if (right.getLeftHeight() > right.getRightHeight()) {
                right.rightRotate();
            }
            leftRotate();
        }
        //如果左子树高度与右子树的高度差值大于一，就进行右旋转
        if (getLeftHeight() - getRightHeight() > 1) {
            //如果当前节点左子树的右子树高度高于左子树，其左子树先进行左旋转
            if (left.getRightHeight() > left.getLeftHeight()) {
                left.leftRotate();
            }
            rightRotate();
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
     * 获得该节点为根节点的树的高度
     *
     * @return 高度
     */
    public int getHeight() {
        return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight()) + 1;
    }

    public int getLeftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.getHeight();
        }
    }

    public int getRightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.getHeight();
        }
    }

    /**
     * 对二叉排序树进行左旋转（右子树高度较高）
     */
    public void leftRotate() {
        //创建新节点
        Node newNode = new Node(value);
        //新节点的左子树指向当前节点的左子树
        newNode.left = left;
        //新节点的右子树指向当前节点的右子树的左子树
        newNode.right = right.left;
        //当前节点的值变为其右子树的值
        value = right.value;
        //当前节点的右子树指向其右子树的右子树
        right = right.right;
        //当前节点的左子树指向新节点
        left = newNode;
    }

    /**
     * 对二叉树进行右旋转（左子树高度较高）
     */
    public void rightRotate() {
        //创建新节点，值为当前节点的值
        Node newNode = new Node(value);
        //新节点的右子树为当前节点的右子树
        newNode.right = right;
        //新节点的左子树为当前节点的左子树的右子树
        newNode.left = left.right;
        //当前节点的值为其左子树的值
        value = left.value;
        //当前节点的左子树为其左子树的左子树
        left = left.left;
        //当前节点的右子树为新节点
        right = newNode;
    }
}
