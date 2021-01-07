package listandqueue;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */

public class Demo3 {
    public static void main(String[] args) {
        ArrayAroundQueue aroundQueue = new ArrayAroundQueue(5);
        aroundQueue.addNum(1);
        aroundQueue.addNum(2);
        aroundQueue.addNum(3);
        aroundQueue.addNum(4);
        aroundQueue.showQueue();
        System.out.println(aroundQueue.getNum());
        System.out.println(aroundQueue.getNum());
        aroundQueue.addNum(5);
        aroundQueue.addNum(6);
        aroundQueue.showQueue();
        aroundQueue.getHead();
    }
}

