package hashtable;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class HashTab {
    private LinkedList[] linkedLists;
    private final int size;

    public HashTab(int size) {
        this.size = size;
        //初始化散列表
        linkedLists = new LinkedList[size];
        //初始化每个链表，不然会抛出空指针异常
        for (int i = 0; i < this.size; i++) {
            //对每个链表进行初始化操作
            linkedLists[i] = new LinkedList();
        }
    }

    public void add(Student student) {
        int hashId = getHash(student.id);
        linkedLists[hashId].add(student);
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            linkedLists[i].traverse();
        }
    }

    public void findStuById(int id) {
        int hashId = getHash(id);
        linkedLists[hashId].findStuById(id);
    }

    /**
     * 散列函数，获得散列值
     *
     * @param id 学生的id
     * @return 对应的散列值
     */
    private int getHash(int id) {
        return id % size;
    }

}
