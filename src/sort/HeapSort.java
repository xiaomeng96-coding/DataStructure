package sort;

import java.util.Arrays;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        //堆排序
        heapSort(arr);
        System.out.println("堆排序后结果");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序（升序排序）
     *
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            //将数组调整为大顶堆，长度为未排序数组的长度
            for (int j = arr.length / 2 - 1; j >= 0; j--) {
                adjustHeap(arr, j, i + 1);
            }
            //调整后，数组首元素就为最大值，与为元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
        }
    }

    /**
     * 将无序数组进行调整，将其调整为大顶堆
     *
     * @param arr    待调整的数组
     * @param index  非叶子节点的索引
     * @param length 待调整数组的长度
     */
    public static void adjustHeap(int[] arr, int index, int length) {
        //保存非叶子节点的值，最后需要进行交换操作
        int temp = arr[index];

        //进行调整操作
        //index*2+1代表其左子树
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            //如果存在右子树，且右子树的值大于左子树，就让索引指向其右子树
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            //如果右子树的值大于该节点的值就交换，同时改变索引index的值
            if (arr[i] > arr[index]) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
            //调整完成后，将temp放到最终调整后的位置
            arr[index] = temp;
        }
    }

}
