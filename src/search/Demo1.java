package search;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {1, 11, -1, 0, 55};
        int result = seqSearch(arr, 1);
        if (result == -1) {
            System.out.println("数组中没有该元素");
        } else {
            System.out.println("该元素在数组的下标是：" + result);
        }
    }

    /**
     * 线性查找，逐值比较
     *
     * @param arr 查找的数组
     * @param num 待查找的数字
     * @return 数字的索引
     */
    public static int seqSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

}
