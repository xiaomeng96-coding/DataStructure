package linkedlist;

/**
 * 定义节点
 */
class StudentNode {
    int id;
    String name;
    /**
     * 用于保存下一个节点的地址
     */
    StudentNode next;

    public StudentNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
