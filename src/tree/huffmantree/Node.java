package tree.huffmantree;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class Node implements Comparable<Node> {
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
     * 重写比较函数，用于排序
     */
    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }

    public void preTraverse() {
        System.out.print(this.value + " ");
        if (this.left != null) {
            this.left.preTraverse();
        }
        if (this.right != null) {
            this.right.preTraverse();
        }
    }
}
