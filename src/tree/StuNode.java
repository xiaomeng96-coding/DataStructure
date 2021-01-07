package tree;

/**
 * 二叉树中的一个节点
 * 保存了学生信息和左右孩子信息
 */
class StuNode {
    int id;
    String name;
    StuNode left;
    StuNode right;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StuNode getLeft() {
        return left;
    }

    public void setLeft(StuNode left) {
        this.left = left;
    }

    public StuNode getRight() {
        return right;
    }

    public void setRight(StuNode right) {
        this.right = right;
    }

    public StuNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StuNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preTraverse() {
        //父节点的位置
        System.out.println(this);
        if (left != null) {
            left.preTraverse();
        }
        if (right != null) {
            right.preTraverse();
        }
    }

    /**
     * 中序遍历
     */
    public void midTraverse() {
        if (left != null) {
            left.midTraverse();
        }
        //父节点的位置
        System.out.println(this);
        if (right != null) {
            right.midTraverse();
        }
    }

    /**
     * 后序遍历
     */
    public void lastTraverse() {
        if (left != null) {
            left.lastTraverse();
        }
        if (right != null) {
            right.lastTraverse();
        }
        //父节点的位置
        System.out.println(this);
    }

}
