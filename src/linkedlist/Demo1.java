package linkedlist;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.traverseNode();
        System.out.println();
        //创建学生节点，并插入链表
        StudentNode student1 = new StudentNode(1, "Nyima");
        StudentNode student3 = new StudentNode(3, "Lulu");
        linkedList.addNode(student1);
        linkedList.addNode(student3);
        linkedList.traverseNode();
        System.out.println();

        //按id大小插入
        System.out.println("有序插入");
        StudentNode student2 = new StudentNode(0, "Wenwen");
        linkedList.addByOrder(student2);
        linkedList.traverseNode();
        System.out.println();

        //按id修改学生信息
        System.out.println("修改学生信息");
        student2 = new StudentNode(1, "Hulu");
        linkedList.changeNode(student2);
        linkedList.traverseNode();
        System.out.println();

        //根据id删除学生信息
        System.out.println("删除学生信息");
        student2 = new StudentNode(1, "Hulu");
        linkedList.deleteNode(student2);
        linkedList.traverseNode();
        System.out.println();

        //获得倒数第几个节点
        System.out.println("获得倒数节点");
        System.out.println(linkedList.getStuByRec(2));
        System.out.println();

        //翻转链表
        System.out.println("翻转链表");
        LinkedList newLinkedList = linkedList.reverseList();
        newLinkedList.traverseNode();
        System.out.println();

        //倒序遍历链表
        System.out.println("倒序遍历链表");
        newLinkedList.reverseTraverse();

    }
}

