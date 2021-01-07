package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo3 {
    public static void main(String[] args) {
        //创建根节点
        BinarySearchTree tree = new BinarySearchTree();

        //手动创建节点
        Student student1 = new Student(1, "A");
        Student student2 = new Student(2, "B");
        Student student3 = new Student(3, "C");
        Student student4 = new Student(4, "D");
        Student student5 = new Student(5, "E");
        student1.setLeft(student2);
        student1.setRight(student3);
        student2.setLeft(student4);
        student3.setRight(student5);

        //指定根节点
        tree.setRoot(student1);

        //查找
        tree.preSearch(3);
        tree.midSearch(4);
        tree.lastSearch(7);

    }
}

