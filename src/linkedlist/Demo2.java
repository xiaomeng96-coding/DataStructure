package linkedlist;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */

public class Demo2 {
    public static void main(String[] args) {
        BidirectionalList bidirectionalList = new BidirectionalList();
        bidirectionalList.addNode(new PersonNode(1, "Nyima"));
        bidirectionalList.addNode(new PersonNode(2, "Lulu"));
        bidirectionalList.traverseNode();
        System.out.println();

        System.out.println("修改节点信息");
        bidirectionalList.changeNode(new PersonNode(2, "Wenwen"));
        bidirectionalList.traverseNode();
        System.out.println();

        //删除节点
        System.out.println("删除节点");
        bidirectionalList.deleteNode(new PersonNode(1, "Nyima"));
        bidirectionalList.traverseNode();
    }
}

