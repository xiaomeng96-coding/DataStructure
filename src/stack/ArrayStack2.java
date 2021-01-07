package stack;

import java.util.EmptyStackException;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */
class ArrayStack2 {
    private final int maxSize;
    int[] stack;
    private int top;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int i) {
        if (isFull()) {
            throw new StackOverflowError("栈满");
        }
        //压栈
        top++;
        stack[top] = i;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int retNum = stack[top];
        top--;
        return retNum;
    }

    public void traverse() {
        for (int thiChar : stack) {
            System.out.println(thiChar);
        }
    }

    /**
     * 判断符号的优先级
     *
     * @param operation 传入运算符
     * @return 返回优先级
     */
    public int getPriority(int operation) {
        if (operation == '*' || operation == '/') {
            return 2;
        } else if (operation == '+' || operation == '-') {
            return 1;
        } else if (operation >= '0' && operation <= '9') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 比较栈顶元素和传入字符的优先级大小
     *
     * @param operation 传入字符
     * @return true则是传入字符优先级大于栈顶字符，false反之
     */
    public boolean comparePriority(int operation) {
        if (isEmpty()) {
            return true;
        } else {
            int priority1 = getPriority(operation);
            int priority2 = getPriority(stack[top]);
            return priority1 > priority2;
        }
    }

    /**
     * 判断该位置是不是一个符号
     *
     * @param operation 该位置的符号
     * @return 判断结果
     */
    public boolean isOperation(int operation) {
        return operation == '*' || operation == '/' || operation == '-' || operation == '+';
    }

    /**
     * @param number1   第一个运算的数字
     * @param number2   第二个运算的数字
     * @param operation 运算符
     * @return
     */
    public int calculation(int number1, int number2, int operation) {
        switch (operation) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
            default:
                System.out.println(operation);
                throw new RuntimeException("符号读取错误！");
        }
    }

}
