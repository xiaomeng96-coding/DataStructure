package algorithm;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Demo1 {
        public static void main(String[] args) {
            hanoiTower(5, 'A', 'B', 'C');
        }

        /**
         * 汉诺塔
         *
         * @param num 盘的总数
         * @param a 第一个塔
         * @param b 第二个塔
         * @param c 第三个塔
         */
        public static void hanoiTower(int num, char a, char b, char c) {
            //如果只有一个盘，把这个盘从A移动到C
            if(num == 1) {
                System.out.println("把第" + num + "个盘从" + a + "->" + c);
                return;
            }
            //如果大于等于两个盘，将上面部分的盘从A借助C移动到B
            hanoiTower(num-1, a, c, b);
            //把最下面的盘从A移动到C
            System.out.println("把第" + num + "个盘从" + a + "->" + c);
            //把上面部分的盘从B借助A移动到C
            hanoiTower(num-1, b, a, c);
        }

}
