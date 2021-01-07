package hashtable;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class LinkedList {
    /**
     * 虚拟头节点，私有不可修改
     */
    private Student head = new Student(-1, "");

    /**
     * 插入学生信息
     *
     * @param student 插入学生的信息
     */
    public void add(Student student) {
        if (head.next == null) {
            head.next = student;
            return;
        }

        Student temp = head.next;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = student;
    }

    /**
     * 遍历链表
     */
    public void traverse() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp + " ");
        }
        //换行
        System.out.println();
    }

    /**
     * 通过id查找学生信息
     *
     * @param id 学生id
     */
    public void findStuById(int id) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.id == id) {
                //找到学生，打印学生信息
                System.out.println("该学生信息：" + temp);
                return;
            }
        }

        System.out.println("未找到该学生信息");
    }
}
