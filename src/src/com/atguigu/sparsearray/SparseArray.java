package com.atguigu.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        /**
         * 创建一个原始的二维数组 11*11
         * 0：没有棋子；1：黑子；2：蓝子
         */
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        /**
         * 输出原始数组
         */
        System.out.println("原始二维数组：");
        for (int[] row : chessArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        /**
         * 将原始二维数组转换为稀梳数组
         */
        /**
         * 1. 遍历二维数组，得到非0数据的个数
         */
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        /**
         * 2. 创建对应的稀梳数组
         */
        int[][] sparseArray = new int[sum + 1][3];
        /**
         * 给稀疏数组赋值
         */
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        /**
         * 遍历二维数组，存储非0元素到稀疏数组
         */
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }
        /**
         * 输出稀疏数组的形式
         */
        System.out.println();
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
        System.out.println();
        /**
         * 从稀疏数组恢复从原始二维数组
         */
        int xTotal = sparseArray[0][0];
        int yTotal = sparseArray[0][1];
        int[][] chessArr2 = new int[xTotal][yTotal];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        /**
         * 输出恢复后的二维数组
         */
        for (int[] row : chessArr2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
