package tree.bst;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        //创建二叉排序树
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.addNode(new Node(arr[i]));
        }
        //前序遍历
        System.out.println("前序遍历二叉排序树");
        binarySortTree.preTraverse();
        System.out.println();
        //删除值为5、1、3、10、7的节点
        binarySortTree.deleteNode(2);
        binarySortTree.deleteNode(1);
        binarySortTree.deleteNode(10);
        binarySortTree.deleteNode(7);
        System.out.println("前序遍历二叉排序树");
        binarySortTree.preTraverse();
    }
}


