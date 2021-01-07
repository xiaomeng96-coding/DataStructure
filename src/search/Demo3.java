package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo3 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 11, 11, 11, 11, 30};
        //进行二分查找的数组必须是有序
        Arrays.sort(arr);
        List<Integer> result = binarySearch(arr, 11);
        if (result.size() == 0) {
            System.out.println("未找到该元素");
        } else {
            for (Integer index : result) {
                System.out.println(index);
            }
        }
    }

    /**
     * 二分查找（可以查找重复元素的下标）
     *
     * @param arr 要查找的有序数组
     * @param num 要查找的数字
     * @return 保存了所有该值元素所在的位置
     */
    public static List<Integer> binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        //用户保存查找值下标
        List<Integer> positionList = new ArrayList<>();
        while (left <= right) {
            mid = (left + right) / 2;
            //如果要查找的值大于中间位置的值，说明要查找的值在右边部分
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] > num) {
                //如果要查找的值小于中间位置的值
                //说明要查找的值在左边部分
                right = mid - 1;
            } else {
                //将下标存入到集合中
                positionList.add(mid);
                //用于遍历mid左边的相同元素
                int leftIndex = mid - 1;
                while (leftIndex > 0 && arr[leftIndex] == num) {
                    positionList.add(leftIndex);
                    leftIndex--;
                }

                int rightIndex = mid + 1;
                while (rightIndex < right && arr[rightIndex] == num) {
                    positionList.add(rightIndex);
                    rightIndex++;
                }

                return positionList;
            }
        }

        return positionList;
    }

}
