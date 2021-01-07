package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class BinarySearchTree {
    private Student root;

    public void setRoot(Student root) {
        this.root = root;
    }

    public void preSearch(int id) {
        System.out.println("前序查找");
        if (root == null) {
            System.out.println("树为空！");
            return;
        }
        Student result = root.preSearch(id);
        if (result == null) {
            System.out.println("未找到该元素");
            return;
        }
        System.out.println(result);
        System.out.println();
    }

    public void midSearch(int id) {
        System.out.println("中序查找");
        if (root == null) {
            System.out.println("树为空！");
            return;
        }
        Student result = root.midSearch(id);
        if (result == null) {
            System.out.println("未找到该元素");
            return;
        }
        System.out.println(result);
        System.out.println();
    }

    public void lastSearch(int id) {
        System.out.println("后序查找");
        if (root == null) {
            System.out.println("树为空！");
            return;
        }
        Student result = root.lastSearch(id);
        if (result == null) {
            System.out.println("未找到该元素");
            return;
        }
        System.out.println(result);
        System.out.println();
    }
}
