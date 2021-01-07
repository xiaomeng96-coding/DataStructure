package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo4 {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 0, 11, 11, 11, 11, 30};
        //进行二分查找的数组必须是有序
        Arrays.sort(arr);
        List<Integer> result = insertSearch(arr, -1);
        if (result.size() == 0) {
            System.out.println("未找到该元素");
        } else {
            for (Integer index : result) {
                System.out.println(index);
            }
        }
    }

    /**
     * 插值查找（可以查找重复元素的下标）
     *
     * @param arr 要查找的有序数组
     * @param num 要查找的数字
     * @return 保存了所有该值元素所在的位置
     */
    public static List<Integer> insertSearch(int[] arr, int num) {
        List<Integer> positionList = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            //插值查找的自适应算法
            mid = left + (right - left) * (num - arr[left]) / (arr[right] - arr[left]);
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                //找到了该元素的位置
                positionList.add(mid);
            }

            //继续查找mid附近值相同的元素
            int leftIndex = mid - 1;
            while (leftIndex >= 0 && arr[leftIndex] == num) {
                positionList.add(leftIndex);
                leftIndex--;
            }
            int rightIndex = mid + 1;
            while (rightIndex <= right && arr[rightIndex] == num) {
                positionList.add(rightIndex);
                rightIndex++;
            }
            return positionList;
        }
        return positionList;
    }

}
