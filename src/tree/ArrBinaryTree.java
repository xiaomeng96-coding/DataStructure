package tree;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */
class ArrBinaryTree {
    int[] arr;
    final int STEP = 2;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 数组的前序遍历
     */
    public void preTraverse() {
        preTraverse(0);
    }

    /**
     * 数组的前序遍历
     *
     * @param index 遍历到的数组元素下标
     */
    private void preTraverse(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！");
            return;
        }
        System.out.print(arr[index] + " ");
        //向左递归
        if ((index * STEP) + 1 < arr.length) {
            preTraverse((index * STEP) + 1);
        }
        //向右递归
        if ((index * STEP) + 2 < arr.length) {
            preTraverse((index * STEP) + 2);
        }
    }

    public void midTraverse() {
        midTraverse(0);
    }

    private void midTraverse(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空!");
        }

        //左递归
        if ((index * STEP) + 1 < arr.length) {
            midTraverse((index * STEP) + 1);
        }
        System.out.print(arr[index] + " ");
        //右递归
        if ((index * STEP) + 2 < arr.length) {
            midTraverse((index * STEP) + 2);
        }
    }

    public void lastTraverse() {
        lastTraverse(0);
    }

    private void lastTraverse(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空!");
        }
        //左递归
        if ((index * STEP) + 1 < arr.length) {
            lastTraverse((index * STEP) + 1);
        }
        //右递归
        if ((index * STEP) + 2 < arr.length) {
            lastTraverse((index * STEP) + 2);
        }
        System.out.print(arr[index] + " ");
    }

}
