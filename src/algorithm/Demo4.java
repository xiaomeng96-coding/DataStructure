package algorithm;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Demo4 {
    public static void main(String[] args) {
        splitChange(123);
    }

    /**
     * 拆分零钱
     *
     * @param money 钱币总金额
     */
    public static void splitChange(int money) {
        //零钱金额，纸币的种类
        int[] prices = {100, 50, 20, 10, 5, 1};
        //用于记录每种纸币的数量，下标与prices数组的下标对应
        int[] counts = new int[prices.length];
        //剩下的金额
        int surplus = money;
        if (money > 0) {
            //如果剩下的金额大于0
            while (surplus > 0) {
                //从大金额向小金额进行凑数
                for (int i = 0; i < prices.length; i++) {
                    //每张钱币的数量
                    int count = 0;
                    //如果该金额的钱币小于总金额，该钱币数量+1
                    while (surplus - prices[i] >= 0) {
                        count++;
                        surplus -= prices[i];
                    }
                    counts[i] = count;
                }
            }
        }


        //打印结果
        System.out.println("凑成" + money + "元");
        for (int i = 0; i < prices.length; i++) {
            if (counts[i] != 0) {
                System.out.println("需要" + prices[i] + "元的纸币" + counts[i] + "张");
            }
        }
    }

}
