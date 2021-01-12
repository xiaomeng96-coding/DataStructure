package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Merge {

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 2, 8, 7, 4};
        MergeSort mergeSort = new MergeSort(arr.length);
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序：");
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
}

