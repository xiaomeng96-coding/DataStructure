package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();

        //手动创建节点，并放入二叉树中
        StuNode stu1 = new StuNode(1, "A");
        StuNode stu2 = new StuNode(2, "B");
        StuNode stu3 = new StuNode(3, "C");
        StuNode stu4 = new StuNode(4, "D");
        stu1.setLeft(stu2);
        stu1.setRight(stu3);
        stu3.setRight(stu4);
        binaryTree.setRoot(stu1);

        //前序遍历
        binaryTree.preTraverse();
        //中序遍历
        binaryTree.midTraverse();
        //后序遍历
        binaryTree.lastTraverse();
    }
}

