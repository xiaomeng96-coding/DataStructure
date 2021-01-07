package recursion;

/**
 * @author: ZhiHao
 * @date: 2021/1/6
 * @version: 1.0
 */

public class Demo2 {
    /**
     * 创建皇后所放位置的数组，数组的下标代表行号，数组中的值代表所在的列号
     */
    static int sum = 0;
    int max = 8;
    int[] arr = new int[max];

    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        //放入第一个皇后，开始求后面的皇后
        demo.check(0);
        System.out.println("一共有" + sum + "种放法");
    }

    /**
     * 打印数组元素
     */
    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sum++;
        System.out.println();
    }

    /**
     * 判断该位置的皇后与前面几个是否冲突
     *
     * @param position 需要判断的皇后的位置
     * @return true代表冲突，false代表不冲突
     */
    public boolean judge(int position) {
        for (int i = 0; i < position; i++) {
            //如果两个皇后在同一列或者同一斜线，就冲突
            //因为数组下标代表行数，所以不会存在皇后在同一行
            //所在行数-所在行数 如果等于 所在列数-所在列数，则两个皇后在同一斜线上
            if (arr[i] == arr[position] || (position - i) == Math.abs(arr[position] - arr[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查该皇后应放的位置
     *
     * @param queen 要检查的皇后
     */
    public void check(int queen) {
        if (queen == max) {
            //所有的皇后都放好了，打印并返回
            print();
            return;
        }
        //把皇后放在每一列上，看哪些不会和之前的冲突
        for (int i = 0; i < max; i++) {
            //把第queen+1个皇后放在第i列
            arr[queen] = i;
            if (!judge(queen)) {
                //不冲突，就去放下一个皇后
                check(queen + 1);
            }
        }
    }

}
