package linkedlist;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */

public class Demo3 {
    public static void main(String[] args) {
        CircularList circularList = new CircularList();
        AttenderNode node1 = new AttenderNode(1);
        AttenderNode node2 = new AttenderNode(2);
        AttenderNode node3 = new AttenderNode(3);
        AttenderNode node4 = new AttenderNode(4);
        circularList.addNode(node1);
        circularList.addNode(node2);
        circularList.addNode(node3);
        circularList.addNode(node4);
        System.out.println("约瑟夫环");
        AttenderNode[] arr = circularList.killAttender(1, 4);
        for (AttenderNode node : arr) {
            System.out.println(node);
        }
    }
}

