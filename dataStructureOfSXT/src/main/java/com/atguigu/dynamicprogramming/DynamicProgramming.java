package com.atguigu.dynamicprogramming;

import lombok.val;

import java.util.Arrays;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/7/2021 12:12 PM
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3}; // 物品的重量
        int[] val = {1500, 3000, 2000}; // 物品的价值
        int bagCapacity = 4;    // 背包容量
        bagProblem(weight, val, bagCapacity);
    }

    public static void bagProblem(int[] weight, int[] val, int bagCapacity) {
        int countOfGoods = val.length; // 物品的数量
        int[][] v = new int[countOfGoods + 1][bagCapacity + 1]; // 前i个商品中，能够装入容量为j的背包中的商品的总价值
        int[][] path = new int[countOfGoods + 1][bagCapacity + 1];

        // 初始化第一行和第一列，本程序中这里可以不处理，默认为0
        Arrays.fill(v[0], 0);
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v.length; i++) {
            System.out.println(Arrays.toString(v[i]));
        }

        /**
         * 动态规划处理
         */
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - weight[i - 1]]);
                    // 为了记录物品放入背包的状况，不能直接使用上面的公式，需要使用if-else来替代
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - weight[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - weight[i - 1]];
                        path[i][j] = 1; // 把当前情况记录到path
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < v.length; i++) {
            System.out.println(Arrays.toString(v[i]));
        }
        System.out.println();
        int maxRowIndex = v.length - 1;
        int maxColIndex = v[0].length - 1;
        while (maxColIndex > 0 && maxRowIndex > 0) {    // 从path的最后开始找
            if (path[maxRowIndex][maxColIndex] != 0) {
                System.out.println("放入第"+maxRowIndex + "个物品");
                maxColIndex -= weight[maxRowIndex - 1];
            }
            maxRowIndex--;
        }
    }
}
