package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo6 {
    public static void main(String[] args) {
        //初始化节点
        SubStudent student1 = new SubStudent(1, "1");
        SubStudent student2 = new SubStudent(2, "3");
        SubStudent student3 = new SubStudent(3, "6");
        SubStudent student4 = new SubStudent(4, "8");
        SubStudent student5 = new SubStudent(5, "10");
        SubStudent student6 = new SubStudent(6, "14");

        //手动创建二叉树
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        student1.setLeft(student2);
        student1.setRight(student3);
        student2.setLeft(student4);
        student2.setRight(student5);
        student3.setLeft(student6);

        tree.setRoot(student1);

        tree.midThreaded();

        //得到第五个节点的前驱节点和后继节点
        System.out.println("第五个节点的前驱节点和后继节点");
        System.out.println(student5.getLeft());
        System.out.println(student5.getRight());

        //遍历线索化二叉树
        System.out.println("遍历线索化二叉树");
        tree.midThreadedTraverse();

    }
}

