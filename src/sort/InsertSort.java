package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 10, 2};
        //从数组的第二个元素开始选择位置插入
        //因为第一个元素已经放入了有序数组中
        for (int i = 1; i < arr.length; i++) {
            //保存该位置上元素的值,后面移动元素可能会覆盖该位置上元素的值
            int temp = arr[i];
            //变量j用于遍历前面的有序数组
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                //如果有序数组中的元素大于temp，则后移一个位置
                arr[j] = arr[j - 1];
                j--;
            }

            //j选择所指位置就是待插入的位置
            if (j != i) {
                arr[j] = temp;
            }
        }
        System.out.println("插入排序：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
