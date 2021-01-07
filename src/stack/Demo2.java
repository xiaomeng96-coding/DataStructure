package stack;

/**
 * @author: ZhiHao
 * @date: 2021/1/6
 * @Version: 1.0
 */

public class Demo2 {
    public static void main(String[] args) {
        String formula = "12+3*15+3/3";
        //索引，用来读取字符串中的元素
        int index = 0;
        //保存读取到的数字和符号
        int number1 = 0;
        int number2 = 0;
        int thisChar = ' ';
        //用于拼接数字
        StringBuilder spliceNumber = new StringBuilder();
        //数栈和符号栈
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operationStack = new ArrayStack2(10);
        //保存运算结果
        int result;

        //开始读取字符串中的元素
        for (index = 0; index < formula.length(); index++) {
            thisChar = formula.charAt(index);
            if (operationStack.isOperation(thisChar)) {
                if (operationStack.comparePriority(thisChar)) {
                    operationStack.push(thisChar);
                } else {
                    int popChar = operationStack.pop();
                    number2 = numberStack.pop();
                    number1 = numberStack.pop();
                    //获得运算结果
                    result = operationStack.calculation(number1, number2, popChar);
                    operationStack.push(thisChar);
                    numberStack.push(result);
                }
            } else {
                //如果是数字，就一直读取
                while (thisChar >= '0' && thisChar <= '9') {
                    //可能该数字为多位数，所以不能只存入一位数字
                    spliceNumber.append(thisChar - '0');
                    System.out.println("拼接字符串 " + spliceNumber);
                    index++;
                    //如果已经读了最后一个数字了，就停下来
                    if (index >= formula.length()) {
                        break;
                    }
                    thisChar = formula.charAt(index);
                }
                int number = Integer.parseInt(spliceNumber.toString());
                numberStack.push(number);
                //初始化spliceNumber
                spliceNumber = new StringBuilder();
                index--;
            }
        }

        while (!operationStack.isEmpty()) {
            int popChar = operationStack.pop();
            number2 = numberStack.pop();
            number1 = numberStack.pop();
            //获得运算结果
            result = operationStack.calculation(number1, number2, popChar);
            numberStack.push(result);
        }

        System.out.println(numberStack.pop());
    }
}

