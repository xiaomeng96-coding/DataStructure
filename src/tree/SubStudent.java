package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class SubStudent {
    private int id;
    private String name;
    private SubStudent left;
    private SubStudent right;
    /**
     * 左、右指针的类型，0-->指向的是左右孩子，1-->指向的是前驱、后续节点
     */
    private int leftType = 0;
    private int rightType = 0;

    public SubStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubStudent getLeft() {
        return left;
    }

    public void setLeft(SubStudent left) {
        this.left = left;
    }

    public SubStudent getRight() {
        return right;
    }

    public void setRight(SubStudent right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
