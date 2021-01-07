package hashtable;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class Student {
    int id;
    String name;
    Student next;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
