package listandqueue;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 * @Description: TODO
 **/

public class Demo2 {
    public static void main(String[] args) {
        // 用数组模拟队列
        ArrayQueue queue = new ArrayQueue(5);
        queue.addNum(1);
        queue.addNum(2);
        queue.addNum(3);
        queue.addNum(4);
        queue.addNum(5);
        System.out.println(queue.getNum());
        queue.showQueue();
    }
}

