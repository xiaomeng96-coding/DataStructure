package linkedlist;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */
class AttenderNode {
    int id;
    AttenderNode next;

    public AttenderNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "KillerNode{" +
                "id=" + id +
                '}';
    }

}
