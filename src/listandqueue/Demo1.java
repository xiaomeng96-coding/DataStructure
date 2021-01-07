package listandqueue;

/**
 * @author: ZhiHao
 * @date: 2021/1/6
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        //创建一个二维数组
        int[][] arr1 = new int[11][11];
        //向二维数组里放值
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        arr1[3][4] = 3;

        //打印二维数组
        System.out.println("遍历二维数组");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr1[i][j] + "   ");
            }
            System.out.println();
        }

        //二维数组----->稀疏数组
        //遍历二维数组中有效值的个数,用sum来记录
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != 0) {
                    //二维数组中元素不为0即为有效值
                    sum++;
                }
            }
        }

        //创建稀疏数组
        //行数为sum+1，第一行用于保存二维数组的行列及有效值个数，列数固定为3
        int[][] sparseArr = new int[sum + 1][3];
        //存入二维数组的行列及有效值个数
        sparseArr[0][0] = arr1.length;
        sparseArr[0][1] = arr1[0].length;
        sparseArr[0][2] = sum;

        //再次遍历二维数组，将有效值存入稀疏数组
        //用于保存稀疏数组的行数
        int count = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != 0) {
                    //将值存入稀疏数组
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr1[i][j];
                    count++;
                }
            }
        }

        //打印稀疏数组
        System.out.println("遍历稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[0].length; j++) {
                System.out.print(sparseArr[i][j] + "   ");
            }
            System.out.println();
        }


        //稀疏数组------>二维数组
        //先得到二位数组的行列数
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] arr2 = new int[row][col];

        //遍历稀疏数组，同时给二维数组赋值
        for (int i = 1; i < sparseArr.length; i++) {
            row = sparseArr[i][0];
            col = sparseArr[i][1];
            //该位置上对应的值
            int val = sparseArr[i][2];
            arr2[row][col] = val;
        }

        //打印二维数组
        System.out.println("遍历还原后的二维数组");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.print(arr2[i][j] + "   ");
            }
            System.out.println();
        }
    }

}
