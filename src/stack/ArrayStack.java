package stack;

import java.util.EmptyStackException;

/**
 * @author: ZhiHao
 * @date: 2021/1/6
 * @Version: 1.0
 */
class ArrayStack {
    private final int maxSize;
    int[] stack;
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
        top = -1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 压栈
     */
    public void push(int i) {
        if (isFull()) {
            throw new StackOverflowError("栈满");
        }
        //压栈
        top++;
        stack[top] = i;
    }

    /**
     * 出栈
     * @return int
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int retNum = stack[top];
        top--;
        return retNum;
    }
}
