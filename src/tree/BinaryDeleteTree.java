package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class BinaryDeleteTree {
    StudentNode root;

    public void setRoot(StudentNode root) {
        this.root = root;
    }

    /**
     * 删除节点
     *
     * @param id 删除节点的id
     */
    public void deleteNode(int id) {
        System.out.println("删除节点");
        if (root.id == id) {
            root = null;
            System.out.println("根节点被删除");
            return;
        }
        //调用删除方法
        root.deleteNode(id);
    }
}
