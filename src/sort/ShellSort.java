package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 4, 5, 8, 2, 0};
        int temp;
        //将数组分为gap组,每个组内部进行插入排序
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //i用来指向未排序数组的首个元素
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                int j = i;
                //找到temp应该插入的位置,需要先判断数组是否越界
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                if (j != i) {
                    arr[j] = temp;
                }
            }
        }
        System.out.println("希尔排序：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
