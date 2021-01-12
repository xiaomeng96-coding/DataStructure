package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class MergeSort {
    /**
     * 临时数组，用于合并时存放元素
     */
    private int[] temp;

    public MergeSort() {
    }

    public MergeSort(int length) {
        temp = new int[length];
    }

    /**
     * 将分解的序列进行合并，合并的同时完成排序
     *
     * @param arr   待合并的数组
     * @param left  数组左边界
     * @param right 数组右边界
     */
    private void merge(int[] arr, int left, int right) {
        //两个序列的分界点
        int mid = (left + right) / 2;
        //temp数组中插入的位置
        int tempLeft = 0;
        int arrLeft = left;
        //第二个序列的首元素下标
        int arrRight = mid + 1;

        while (arrLeft <= mid && arrRight <= right) {
            //如果第一个序列的元素小于第二序列的元素，就将其放入temp中
            if (arr[arrLeft] <= arr[arrRight]) {
                temp[tempLeft] = arr[arrLeft];
                arrLeft++;
            } else {
                temp[tempLeft] = arr[arrRight];
                arrRight++;
            }
            tempLeft++;
        }


        //将不为空的序列中的元素依次放入temp中
        while (arrLeft <= mid) {
            temp[tempLeft] = arr[arrLeft];
            tempLeft++;
            arrLeft++;
        }

        while (arrRight <= right) {
            temp[tempLeft] = arr[arrRight];
            tempLeft++;
            arrRight++;
        }

        //将临时数组中的元素放回数组arr中
        tempLeft = 0;
        arrLeft = left;
        while (arrLeft <= right) {
            arr[arrLeft] = temp[tempLeft];
            arrLeft++;
            tempLeft++;
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, right);
        }
    }

}
