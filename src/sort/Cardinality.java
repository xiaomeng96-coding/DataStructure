package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Cardinality {

    public static void main(String[] args) {
        int[] arr = {43, 52, 1, 89, 190};
        CardinalitySort cardinalitySort = new CardinalitySort();
        cardinalitySort.sort(arr);
        System.out.println("基数排序：");
        for (int a : arr) {
            System.out.print(a+" ");
        }
    }
}

