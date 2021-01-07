package listandqueue;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */
class ArrayQueue {
    /**
     * 队列的大小
     */
    int maxSize;
    /**
     * 用数组来实现队列
     */
    int[] arr;
    /**
     * 指向队列首元素的前一个位置
     */
    int front;
    /**
     * 指向队列的尾元素
     */
    int rear;

    public ArrayQueue(int maxSize) {   //含参数构造器
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        //front指向队列首元素的前一个位置
        front = -1;
        rear = -1;
    }


    public boolean isFull() {
        return rear == maxSize - 1;
    }


    public boolean isEmpty() {
        return front == rear;
    }


    public void addNum(int num) {
        if (isFull()) {
            System.out.println("队列已满，无法在进行入队操作");
            return;   // 返回
        }
        //队尾标记后移，指向要放入的元素的位置
        rear++;
        arr[rear] = num;
    }

    public int getNum() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法出队");
        }
        //队首标记后移，指向队首元素
        System.out.print("出队元素是：");
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");
        }
        System.out.println("遍历队列");
        //从front+1开始读取元素
        for (int start = front + 1; start <= rear; start++) {
            System.out.println(arr[start]);
        }
    }
}
