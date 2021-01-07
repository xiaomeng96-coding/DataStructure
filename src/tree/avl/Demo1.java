package tree.avl;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 5, 8, 9};
        AVLTree tree = new AVLTree();
        for (int value : arr) {
            tree.addNode(new Node(value));
        }
        System.out.println("左右子树高度差值为 " + tree.getDifference());
        System.out.println("前序遍历");
        tree.preTraverse();
    }
}

