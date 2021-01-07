package linkedlist;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */
class PersonNode {
    int id;
    String name;
    /**
     * 指向下一个节点
     */
    PersonNode next;
    /**
     * 指向前一个节点
     */
    PersonNode front;

    public PersonNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
