package stack;

/**
 * @author: ZhiHao
 * @date: 2021/1/6
 * @Version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        //压栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //出栈
        System.out.println(stack.pop());
    }
}

