package recursion;

/**
 * @author: ZhiHao
 * @date: 2021/1/6
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        //得到地图
        int length = 7;
        int width = 6;
        int[][] map = getMap(length, width);

        //设置一些障碍
        map[1][2] = 1;
        map[2][2] = 1;

        //打印地图
        System.out.println("地图如下");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //走迷宫
        getWay(map, 1, 1);

        //行走路径
        System.out.println("行走路径");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 创建地图
     *
     * @param length 地图的长
     * @param width  地图的宽
     * @return 创建好的地图
     */
    public static int[][] getMap(int length, int width) {
        int[][] map = new int[length][width];
        //先将第一行和最后一行设置为1（边界）
        for (int i = 0; i < width; i++) {
            map[0][i] = 1;
            map[length - 1][i] = 1;
        }
        //再将第一列和最后一列设置为1
        for (int i = 0; i < length; i++) {
            map[i][0] = 1;
            map[i][width - 1] = 1;
        }
        return map;
    }

    /**
     * 开始走迷宫
     *
     * @param map 地图
     * @param i   起点横坐标
     * @param j   七点纵坐标
     * @return 能否走通，true能走通，false反之
     */
    public static boolean getWay(int[][] map, int i, int j) {
        int length = map.length;
        int width = map[0].length;
        //假设右下角为终点
        if (map[length - 2][width - 2] == 2) {
            //走通了，返回true
            return true;
        } else {
            if (map[i][j] == 0) {
                //假设改路能走通
                map[i][j] = 2;
                //行走策略 右->下->左->上
                if (getWay(map, i, j + 1)) {
                    return true;
                } else if (getWay(map, i + 1, j)) {
                    return true;
                } else if (getWay(map, i - 1, j)) {
                    return true;
                } else if (getWay(map, i, j - 1)) {
                    return true;
                }
                //右下左上都走不通
                map[i][j] = 3;
            } else {
                //改路已经被标记过了，不用再走了，直接返回false
                return false;
            }
        }
        return false;
    }

}
