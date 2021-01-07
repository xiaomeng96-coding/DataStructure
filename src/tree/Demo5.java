package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //前序遍历
        System.out.println("数组前序遍历");
        arrBinaryTree.preTraverse();
        System.out.println();

        //中序遍历
        System.out.println("数组中序遍历");
        arrBinaryTree.midTraverse();
        System.out.println();

        //后序遍历
        System.out.println("数组后序遍历");
        arrBinaryTree.lastTraverse();
        System.out.println();
    }
}

