package sort;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class CardinalitySort {
    /**
     * 进行基数排序
     *
     * @param arr 待排序的数组
     */
    public void sort(int[] arr) {
        //创建一个二维数组，用于表示桶
        //桶的个数固定为10个（个位是0~9），最大容量由数组的长度决定
        int maxSize = arr.length;
        int[][] bucket = new int[10][maxSize];
        //用于记录每个桶中有多少个元素
        int[] elementCounts = new int[10];

        //获得该数组中最大元素的位数
        int maxDigits = getMaxDigits(arr);

        //将数组中的元素放入桶中, step是在求数组位数时，需要除以的倍数
        for (int time = 1, step = 1; time <= maxDigits; time++, step *= 10) {
            for (int i = 0; i < arr.length; i++) {
                //取出所需的位数
                int digits = arr[i] / step % 10;
                //放入到对应的桶中 [digits]代表桶的编号
                //[elementCounts[digits]]代表放入该桶的位置
                bucket[digits][elementCounts[digits]] = arr[i];
                //桶中元素个数+1
                elementCounts[digits]++;
            }

            //将桶中的元素重新放回到数组中
            //用于记录应该放入原数组的哪个位置
            int index = 0;
            for (int i = 0; i < 10; i++) {
                //从桶中按放入顺序依次取出元素，放入原数组
                int position = 0;
                //桶中有元素才取出
                while (elementCounts[i] > 0) {
                    arr[index] = bucket[i][position];
                    position++;
                    elementCounts[i]--;
                    index++;
                }
            }
        }

    }

    /**
     * 得到该数组中最大元素的位数
     *
     * @param arr 待求数组
     * @return 最大元素的位数
     */
    public int getMaxDigits(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //将最大值转为字符串，它的长度就是它的位数
        int digits = (max + "").length();
        return digits;
    }

}
