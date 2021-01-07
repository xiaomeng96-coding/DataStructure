package search;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo2 {
    public static void main(String[] args) {
        //进行二分查找的数组必须是有序
        int[] arr = {-1, 0, 2, 11, 30};
        int result = binarySearch(arr, 11);
        if (result == -1) {
            System.out.println("未找到该元素");
        } else {
            System.out.println("该元素的下标是：" + result);
        }
    }

    /**
     * 二分查找
     *
     * @param arr 要查找的有序数组
     * @param num 要查找的数字
     * @return 对应数字的下标
     */
    public static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            //防止溢出
            int mid = (right - left) / 2 + left;
            //如果要查找的值大于中间位置的值，说明要查找的值在右边部分
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] > num) {
                //如果要查找的值小于中间位置的值
                //说明要查找的值在左边部分
                right = mid - 1;
            } else {
                //找到了该元素
                return mid;
            }
        }
        return -1;
    }

}
