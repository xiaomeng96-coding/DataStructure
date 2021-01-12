package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = {8, 12, 19, -1, 45, 0, 14, 4, 11};
        QuickSort1 sort = new QuickSort1();
        sort.quickSort(arr);
        System.out.println("快速排序：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 快速排序
     *
     * @param arr 待排序的数组
     */
    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr   待排序的数组
     * @param left  左侧开始下标
     * @param right 右侧开始下标
     */
    private void quickSort(int[] arr, int left, int right) {
        //如果分区元素小于等于一个，就返回
        if (right <= left) {
            return;
        }

        //得到基数下标
        int partition = partition(arr, left, right);

        //递归左右两个分区,因为每次是以左边的第一个数为基数，所以右边分区递归需要在partition的右侧开始
        quickSort(arr, left, partition);
        quickSort(arr, partition + 1, right);
    }

    /**
     * 返回基准下标
     *
     * @param arr   待排序的数组
     * @param left  左侧开始下标
     * @param right 右侧开始下标
     * @return 中间值的下标
     */
    private int partition(int[] arr, int left, int right) {
        //以该分区最左边的数为基数
        int pivot = arr[left];

        while (left < right) {
            //右边下标开始向左移动，找到小于基数的值时停止
            while (right > left && arr[right] >= pivot) {
                right--;
            }
            //交换数值，此时pivot保存了arr[left]的值，所以不会丢失
            arr[left] = arr[right];

            //左边下标开始移动，找到大于基数的值时停止
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换数值
            arr[right] = arr[left];
            //基数插入到合适的位置
            arr[left] = pivot;
        }

        //返回基数下标
        return left;

    }
}