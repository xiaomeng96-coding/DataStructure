package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class Student {
    int id;
    String name;
    Student left;
    Student right;
    Student root;

    public Student(int id, String name) {
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

    public Student getLeft() {
        return left;
    }

    public void setLeft(Student left) {
        this.left = left;
    }

    public Student getRight() {
        return right;
    }

    public void setRight(Student right) {
        this.right = right;
    }

    public Student getRoot() {
        return root;
    }

    public void setRoot(Student root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", root=" + root +
                '}';
    }

    /**
     * 前序查找
     *
     * @param id 要查找的学生id
     * @return 查找到的学生
     */
    public Student preSearch(int id) {
        //如果找到了，就返回
        if (this.id == id) {
            return this;
        }

        //在左子树中查找，如果找到了就返回
        Student student = null;
        if (left != null) {
            student = left.preSearch(id);
        }
        if (student != null) {
            return student;
        }

        //在右子树中查找，无论是否找到，都需要返回
        if (right != null) {
            student = right.preSearch(id);
        }
        return student;
    }

    /**
     * 中序查找
     *
     * @param id 要查找的学生id
     * @return 查找到的学生
     */
    public Student midSearch(int id) {
        Student student = null;
        if (left != null) {
            student = left.midSearch(id);
        }
        if (student != null) {
            return student;
        }

        //找到了就返回
        if (this.id == id) {
            return this;
        }

        if (right != null) {
            student = right.midSearch(id);
        }
        return student;
    }

    /**
     * 后序查找
     *
     * @param id 要查找的学生id
     * @return 查找到的学生
     */
    public Student lastSearch(int id) {
        Student student = null;
        if (left != null) {
            student = left.lastSearch(id);
        }
        if (student != null) {
            return student;
        }

        if (right != null) {
            student = right.lastSearch(id);
        }

        if (this.id == id) {
            return this;
        }

        return student;
    }

}
