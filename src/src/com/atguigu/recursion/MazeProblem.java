package com.atguigu.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazeProblem {
    private static int[][] Map;
    private static List<int[]> Wall = new ArrayList<>();
    private static int[] end = new int[2];

    /**
     * 默认为8.7的地图，最右下角，即6.5，表示出口
     */
    public static void main(String[] args) {
        /**
         * 初始化地图
         */
        Map = new int[8][7];
        Wall.add(new int[]{3, 1});
        Wall.add(new int[]{3, 2});
        Wall.add(new int[]{2,2});
        int[][] map = initMap(Map, Wall);
        /**
         * 设置出口与出口
         */
        end[0] = 6;
        end[1] = 5;
        printMap(map);
        setWay(map, 1, 1, end);
        System.out.println("结果为：");
        printMap(map);
    }

    /**
     * 使用递归回溯来给小球找路，找到为true，否则false
     * <p>
     * 约定：0表示没有走过该点；1表示墙，不可走；2表示通路可以走；3表示该点已经走过但是走不通
     * <p>
     * 走的策略：下>右>上>左
     *
     * @param map 地图，二维整数数组
     * @param i,j 起点，整数数组，应只包含两个数
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j, int[] end) {
        /**
         * 如果出口已经是可以走通的状态，结束，找到出口
         */
        if (map[end[0]][end[1]] == 2) {
            return true;
        } else {
            /**
             * 如果该点没有走过
             */
            if (map[i][j] == 0) {
                /**
                 * 假定该点可以走通
                 */
                map[i][j] = 2;
                // 按照下、右、上、左的策略走
                if (setWay(map, i + 1, j, end)) {
                    return true;
                } else if (setWay(map, i, j + 1, end)) {
                    return true;
                } else if (setWay(map, i - 1, j, end)) {
                    return true;
                } else if (setWay(map, i, j - 1, end)) {
                    return true;
                } else {
                    /**
                     * 则表示该点走不通
                     */
                    map[i][j] = 3;
                    return false;
                }
            } else {
                /**
                 * 可能是1，2，3：表示皆不能走，直接返回false
                 */
                return false;
            }
        }
    }

    public static int[][] initMap(int[][] map, List<int[]> wall) {
        for (int i = 0; i < map[0].length; i++) {
            /**
             * 先将首尾两行置为1，1表示墙
             */
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            /**
             * 再将左右两列置为1
             */
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }
        /**
         * 设置档板，也设为1
         */
        for (int[] w : wall) {
            map[w[0]][w[1]] = 1;
        }

        return map;
    }

    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%d\t", map[i][j]);
            }
            System.out.println();
        }
    }
}
