package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2};
        for (int i = 1; i < arr.length; i++) {
            //定义一个标识，来记录这趟大循环是否发生了交换
            boolean flag = true;
            //只需要比较前length-i个数
            //每次排序会确定一个最大的元素
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //发生了交换，标识改为false
                    flag = false;
                }
            }
            //如果这次循环没发生交换，直接停止循环
            if (flag) {
                break;
            }
        }
        System.out.println("冒泡排序：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
