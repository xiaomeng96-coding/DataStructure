package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: ZhiHao
 * @Date: 2021/1/6
 * @Version: 1.0
 */

public class Demo3 {
    static Queue<String> queue = new LinkedList<>();
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        //中缀表达式，加上空格，方便取出
        String infixExpression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        String[] expressionArr = infixExpression.split(" ");
        //用来保存该运算符的类型
        int type;
        //取出的字符串
        String element;
        //弹出栈的字符串
        String stackEle;
        for (int i = 0; i < expressionArr.length; i++) {
            element = expressionArr[i];
            type = judgeOperator(element);
            if (type == 0) {
                //数字，直接入队
                queue.add(element);
            } else if (type == 1) {
                //左括号，直接压栈
                stack.push(element);
            } else if (type == 3) {
                //如果右括号，弹出栈顶元素，直到遇见左括号位置再停下来
                do {
                    stackEle = stack.pop();
                    if (stackEle.equals("(")) {
                        break;
                    }
                    queue.add(stackEle);
                    //弹出栈中的左括号
                } while (!stackEle.equals("("));
            } else if (type == 2) {
                if (stack.isEmpty()) {
                    //如果栈为空，直接入栈
                    stack.push(element);
                    continue;
                }
                int priority1 = getPriority(element);
                //获得栈顶元素，并判断其优先级
                stackEle = stack.peek();
                int priority2 = getPriority(stackEle);
                if (priority2 == 0) {
                    //为左括号，运算符直接入栈
                    stack.push(element);
                } else if (priority1 > priority2) {
                    //该运算符优先级高于栈顶元素优先级，则入栈
                    stack.push(element);
                } else {
                    stackEle = stack.pop();
                    queue.add(stackEle);
                    //重新判断该运算符
                    i--;
                }
            }
        }
        //把最后一个元素出栈并入队
        stackEle = stack.pop();
        queue.add(stackEle);
        //保存队列长度，因为出队过程中队列的长度会被改变
        int length = queue.size();
        for (int i = 0; i < length; i++) {
            element = queue.remove();
            System.out.print(element);
        }
    }

    /**
     * 判断该运算符是不是加减乘除
     *
     * @param operation 运算符
     * @return true则该运算符为加减乘除
     */
    public static boolean firstJudge(String operation) {
        return operation.equals("*") || operation.equals("/") || operation.equals("+") || operation.equals("-");
    }


    /**
     * 判断该字符串的类型
     *
     * @param operation 要判断的字符串
     * @return 3->右括号 2->加减乘除运算符 1->左括号
     */
    public static int judgeOperator(String operation) {
        if (operation.equals(")")) {
            return 3;
        }
        if (firstJudge(operation)) {
            return 2;
        }
        if (operation.equals("(")) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 判断运算符优先级
     *
     * @param operator 要判断的运算符
     * @return 2代表乘除，1代表加减，0代表左括号
     */
    public static int getPriority(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else {
            return 0;
        }

    }

}
