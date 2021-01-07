package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class StudentNode {
    int id;
    String name;
    StudentNode left;
    StudentNode right;

    public StudentNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public StudentNode getLeft() {
        return left;
    }

    public void setLeft(StudentNode left) {
        this.left = left;
    }

    public StudentNode getRight() {
        return right;
    }

    public void setRight(StudentNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 删除节点
     *
     * @param id 删除节点的id
     */
    public void deleteNode(int id) {
        //如果左子树不为空且是要查找的节点，就删除
        if (left != null && left.id == id) {
            left = null;
            System.out.println("删除成功");
            return;
        }

        //如果右子树不为空且是要查找的节点，就删除
        if (right != null && right.id == id) {
            right = null;
            System.out.println("删除成功");
            return;
        }

        //左递归，继续查找
        if (left != null) {
            left.deleteNode(id);
        }

        //右递归，继续查找
        if (right != null) {
            right.deleteNode(id);
        }
    }
}
