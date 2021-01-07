package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo4 {
    public static void main(String[] args) {
        //创建根节点
        BinaryDeleteTree deleteTree = new BinaryDeleteTree();

        //手动创建节点
        StudentNode student1 = new StudentNode(1, "A");
        StudentNode student2 = new StudentNode(2, "B");
        StudentNode student3 = new StudentNode(3, "C");
        StudentNode student4 = new StudentNode(4, "D");
        StudentNode student5 = new StudentNode(5, "E");
        student1.setLeft(student2);
        student1.setRight(student3);
        student2.setLeft(student4);
        student3.setRight(student5);

        //指定根节点
        deleteTree.setRoot(student1);

        //删除节点
        deleteTree.deleteNode(3);
    }
}


