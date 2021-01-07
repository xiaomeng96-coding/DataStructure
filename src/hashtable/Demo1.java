package hashtable;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        //创建学生
        Student student1 = new Student(1, "Nyima");
        Student student2 = new Student(2, "Lulu");
        Student student6 = new Student(6, "WenWen");
        HashTab hashTab = new HashTab(5);
        hashTab.add(student1);
        hashTab.add(student2);
        hashTab.add(student6);
        hashTab.traverse();
        //通过id查找学生信息
        hashTab.findStuById(6);
    }
}

