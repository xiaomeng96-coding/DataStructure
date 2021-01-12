package algorithm;

import java.util.Arrays;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Demo2 {
    public static void main(String[] args) {
        //各个物品的重量
        int[] weight = {1, 4, 3};
        //各个物品的价值
        int[] value = {1500, 3000, 2000};
        //背包的最大容量
        int maxSize = 4;
        //各种方法的价值的最大值，第0行和第0列值为0，方便后续操作
        int[][] maxValue = new int[value.length + 1][maxSize + 1];
        //用于表示物品放入背包的方式
        int[][] method = new int[value.length + 1][maxSize + 1];

        //依次将物品放入背包
        for (int i = 1; i < maxValue.length; i++) {
            for (int j = 1; j < maxValue[0].length; j++) {
                //如果物品的重量大于背包剩余的容量，就不放入
                //i-1是因为下标是从1开始的，减一后才为0
                if (weight[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    //背包剩余的容量
                    int remaining = j - weight[i - 1];
                    //如果放入该物品前的最大价值大于放入该物品后的最大价值，就不放入该物品
                    if (maxValue[i - 1][j] > value[i - 1] + maxValue[i - 1][remaining]) {
                        maxValue[i][j] = maxValue[i - 1][j];
                    } else {
                        maxValue[i][j] = value[i - 1] + maxValue[i - 1][remaining];
                        //存入放入方法
                        method[i][j] = 1;
                    }
                }
            }
        }

        //打印放入背包的最大价值
        for (int[] arr : maxValue) {
            System.out.println(Arrays.toString(arr));
        }


        //打印价值最大的放法
        //存放方法的二维数组的最大下标，从最后开始搜索存放方法
        int i = method.length - 1;
        int j = method[0].length - 1;
        while (i > 0 && j > 0) {
            if (method[i][j] == 1) {
                System.out.println("将第" + i + "个物品放入背包");
                //背包剩余容量
                j -= weight[i - 1];
            }
            i--;
        }
    }

}
