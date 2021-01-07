package linkedlist;

import java.util.Stack;

/**
 * 创建链表
 */
class LinkedList {
    /**
     * 头节点，防止被修改，设置为私有的
     */
    private StudentNode head = new StudentNode(0, "");

    /**
     * 添加节点
     *
     * @param node 要添加的节点
     */
    public void addNode(StudentNode node) {
        //因为头节点不能被修改，所以创建一个辅助节点
        StudentNode temp = head;
        //找到最后一个节点
        while (true) {
            //temp是尾节点就停止循环
            if (temp.next == null) {
                break;
            }
            //不是尾结点就向后移动
            temp = temp.next;
        }
        //现在temp是尾节点了，再次插入
        temp.next = node;
    }

    /**
     * 遍历链表
     */
    public void traverseNode() {
        System.out.println("开始遍历链表");
        if (head.next == null) {
            System.out.println("链表为空");
        }
        //创建辅助节点
        StudentNode temp = head;
        while (true) {
            //遍历完成就停止循环
            if (temp.next == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 按id顺序插入节点
     *
     * @param node
     */
    public void addByOrder(StudentNode node) {
        //如果没有首节点，就直接插入
        if (head.next == null) {
            head.next = node;
            return;
        }
        //辅助节点，用于找到插入位置和插入操作
        StudentNode temp = head;
        //节点的下一个节点存在，且它的id小于要插入节点的id，就继续下移
        while (temp.next != null && temp.next.id < node.id) {
            temp = temp.next;
        }
        //如果temp的下一个节点存在，则执行该操作
        //且插入操作，顺序不能换
        if (temp.next != null) {
            node.next = temp.next;
        }
        temp.next = node;
    }

    /**
     * 根据id来修改节点信息
     *
     * @param node 修改信息的节点
     */
    public void changeNode(StudentNode node) {
        if (head == null) {
            System.out.println("链表为空，请先加入该学生信息");
            return;
        }
        StudentNode temp = head;
        //遍历链表，找到要修改的节点
        while (temp.next != null && temp.id != node.id) {
            temp = temp.next;
        }
        //如果temp已经是最后一个节点，判断id是否相等
        if (temp.id != node.id) {
            System.out.println("未找到该学生的信息，请先创建该学生的信息");
            return;
        }
        //修改学生信息
        temp.name = node.name;
    }

    /**
     * 根据id删除节点
     *
     * @param node 要删除的节点
     */
    public void deleteNode(StudentNode node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        StudentNode temp = head;
        //遍历链表，找到要删除的节点
        if (temp.next != null && temp.next.id != node.id) {
            temp = temp.next;
        }
        //判断最后一个节点的是否要删除的节点
        if (temp.next.id != node.id) {
            System.out.println("请先插入该学生信息");
            return;
        }
        //删除该节点
        temp.next = temp.next.next;
    }

    /**
     * 得到倒数的节点
     *
     * @param index 倒数第几个数
     * @return
     */
    public StudentNode getStuByRec(int index) {
        if (head.next == null) {
            System.out.println("链表为空!");
        }
        StudentNode temp = head.next;
        //用户记录链表长度，因为head.next不为空，此时已经有一个节点了
        //所以length初始化为1
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        if (length < index) {
            throw new RuntimeException("链表越界");
        }

        temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 翻转链表
     *
     * @return 反转后的链表
     */
    public LinkedList reverseList() {
        //链表为空或者只有一个节点，无需翻转
        if (head.next == null || head.next.next == null) {
            System.out.println("无需翻转");
        }
        LinkedList newLinkedList = new LinkedList();
        //给新链表创建新的头结点
        newLinkedList.head = new StudentNode(0, "");
        //用于保存正在遍历的节点
        StudentNode temp = head.next;
        //用于保存正在遍历节点的下一个节点
        StudentNode nextNode = temp.next;
        while (true) {
            //插入新链表
            temp.next = newLinkedList.head.next;
            newLinkedList.head.next = temp;
            //移动到下一个节点
            temp = nextNode;
            nextNode = nextNode.next;
            if (temp.next == null) {
                //插入最后一个节点
                temp.next = newLinkedList.head.next;
                newLinkedList.head.next = temp;
                head.next = null;
                return newLinkedList;
            }
        }
    }

    public void reverseTraverse() {
        if (head == null) {
            System.out.println("链表为空");
        }

        StudentNode temp = head.next;
        //创建栈，用于存放遍历到的节点
        Stack<StudentNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
