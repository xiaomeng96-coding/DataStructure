package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class BinaryTree {
    /**
     * 根节点
     */
    private StuNode root;

    public void setRoot(StuNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preTraverse() {
        if (root != null) {
            System.out.println("前序遍历");
            root.preTraverse();
            System.out.println();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     * 中序遍历
     */
    public void midTraverse() {
        if (root != null) {
            System.out.println("中序遍历");
            root.midTraverse();
            System.out.println();
        } else {
            System.out.println("二叉树为空！");
        }
    }

    /**
     * 后序遍历
     */
    public void lastTraverse() {
        if (root != null) {
            System.out.println("后序遍历");
            root.lastTraverse();
            System.out.println();
        } else {
            System.out.println("二叉树为空！");
        }
    }
}
