package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 10, 2};

        //从第0个元素开始比较，一共循环length-1次，最后一个无须进行排序
        for (int i = 0; i < arr.length - 1; i++) {
            //保存最小元素的下标
            int min = i;
            //将该元素与剩下的元素比较，找出最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                //保存最小元素的下标
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //交换元素
            //如果不是arr[i]不是最小的元素，就交换
            if (min != i) {
                int temp;
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println("选择排序：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
