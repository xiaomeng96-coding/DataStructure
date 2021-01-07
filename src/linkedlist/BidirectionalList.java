package linkedlist;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */
class BidirectionalList {
    private final PersonNode head = new PersonNode(-1, "");

    /**
     * 判断双向链表是否为空
     *
     * @return 判空结果
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 添加节点
     *
     * @param node 要被添加的节点
     */
    public void addNode(PersonNode node) {
        PersonNode temp = head;
        if (temp.next != null) {
            temp = temp.next;
        }
        //插入在最后一个节点的后面
        temp.next = node;
        node.front = temp;
    }

    /**
     * 遍历链表
     *
     * @param
     */
    public void traverseNode() {
        System.out.println("遍历链表");
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        PersonNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 修改节点信息
     *
     * @param node 要修改的节点
     */
    public void changeNode(PersonNode node) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        PersonNode temp = head.next;
        //用于判定是否做了修改
        boolean flag = false;
        while (temp != null) {
            if (temp.id == node.id) {
                //匹配到节点，替换节点
                temp.front.next = node;
                node.next = temp.next;
                flag = true;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("未匹配到改人信息");
        }

    }

    /**
     * 删除节点
     *
     * @param node 要删除的节点
     */
    public void deleteNode(PersonNode node) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        PersonNode temp = head.next;
        //查看是否删除成功
        boolean flag = false;
        while (temp != null) {
            if (temp.id == node.id) {
                temp.front.next = temp.next;
                temp.next = null;
                flag = true;
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("未找到该节点");
        }
    }

}
