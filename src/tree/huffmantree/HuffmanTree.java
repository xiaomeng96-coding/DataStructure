package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class HuffmanTree {

    public Node createHuffmanTree(int[] arr) {
        //创建数组用于存放Node
        ArrayList<Node> nodes = new ArrayList<>(arr.length);
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //对集合中的元素进行排序
        Collections.sort(nodes);

        while (nodes.size() > 1) {
            //左右子树在集合中对应的下标
            int leftIndex = 0;
            int rightIndex = 1;

            //取出最小的两个节点
            Node leftNode = nodes.get(leftIndex);
            Node rightNode = nodes.get(rightIndex);
            //创建父节点，并创建左右子树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //从集合中移除两个最小的节点，并将父节点放入集合中
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //再次比较
            Collections.sort(nodes);
        }
        //返回根节点
        return nodes.get(0);
    }
}
