package com.atguigu.graph;


import java.util.Arrays;

class FGraph {
    /**
     * 顶点数组
     */
    private char[] vertexes;
    /**
     * 保存从各个顶点出发到各顶点的距离
     */
    private int[][] dis;
    /**
     * 前驱
     */
    private int[][] pre;

    /**
     * @param length   大小
     * @param matrix   邻接矩阵
     * @param vertexes 顶点数组
     */
    public FGraph(int length, int[][] matrix, char[] vertexes) {
        this.vertexes = Arrays.copyOf(vertexes, vertexes.length);
        this.dis = new int[length][length];
        for (int i = 0; i < length; i++) {
            this.dis[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(this.pre[i], i);
        }
    }

    /**
     * 打印pre数组和dis数组
     */
    public void show() {
        System.out.println("距离矩阵：");
        for (int i = 0; i < this.dis.length; i++) {
            System.out.println(Arrays.toString(this.dis[i]));
        }
        System.out.println("前驱矩阵：");
        for (int i = 0; i < this.pre.length; i++) {
            System.out.println(Arrays.toString(this.pre[i]));
        }
    }

    public void floyd() {
        int len = 0;
        /**
         * 对中间顶点的遍历
         */
        for (int k = 0; k < this.dis.length; k++) {
            /**
             * 从i顶点开始出发
             */
            for (int i = 0; i < this.dis.length; i++) {
                /**
                 * j：到达的顶点
                 */
                for (int j = 0; j < this.dis.length; j++) {
                    len = this.dis[i][k] + this.dis[k][j];
                    if (len < this.dis[i][j]) {
                        this.dis[i][j] = len;
                        this.pre[i][j] = this.pre[k][j];
                    }
                }
            }
        }
    }
}

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/12/2021 5:31 PM
 */
public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        FGraph graph = new FGraph(vertex.length, matrix, vertex);
        graph.show();
        graph.floyd();
        graph.show();
    }
}
