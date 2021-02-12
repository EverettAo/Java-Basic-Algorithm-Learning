package com.atguigu.graph;

import java.util.Arrays;

class KGraph {
    private int edgeCount;  // 边的数
    private int[][] matrix; // 邻接矩阵
    private char[] vertexes;    // 顶点数组
    private static final int INF = Integer.MAX_VALUE;

    public KGraph(int[][] matrix, char[] vertexes) {
        /**
         * 保持隔离，所以用复制的方式
         */
        this.vertexes = Arrays.copyOf(vertexes, vertexes.length);
        this.matrix = new int[vertexes.length][vertexes.length];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        /**
         * 统计边的条数，注意：因为是对称矩阵，所以内层循环从i+1即可
         */
        for (int i = 0; i < this.vertexes.length; i++) {
            for (int j = i + 1; j < this.vertexes.length; j++) {
                if (this.matrix[i][j] != KGraph.INF) {
                    this.edgeCount++;
                }
            }
        }
    }

    /**
     * 打印图的邻接矩阵
     */
    public void showGraph() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < this.vertexes.length; i++) {
            for (int j = 0; j < this.vertexes.length; j++) {
                System.out.printf("%10d\t", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void sortEdges(KEdge[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    KEdge tEdge = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tEdge;
                }
            }
        }
    }

    /**
     * 获取顶点的位置
     *
     * @param c 顶点
     * @return 顶点下标，如果没有，-1
     */
    private int getPosition(char c) {
        for (int i = 0; i < this.vertexes.length; i++) {
            if (this.vertexes[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public KEdge[] getEdges() {
        KEdge[] edges = new KEdge[this.edgeCount];
        int index = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = i + 1; j < this.matrix[i].length; j++) {
                if (this.matrix[i][j] != this.INF && this.matrix[i][j] != 0) {
                    edges[index++] = new KEdge(this.vertexes[i], this.vertexes[j], this.matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /***
     * 获取顶点的终点，用于判断两个顶点的终点是否相同
     * @param ends 记录各个顶点对应的重终点是哪个，此数组是在遍历的过程中，逐步形成的
     * @param v 目标顶点，索引
     * @return 下标为v的顶点对应的终点的下标
     */
    public int getEnds(int[] ends, int v) {
        while (ends[v] != 0) {
            v = ends[v];
        }
        return v;
    }

    public void kruskal() {
        /**
         * 表示最后结果数组的索引
         */
        int index = 0;
        /**
         * 用于保存已有最小生成树中的每个顶点在最小生成树中的终点
         */
        int[] ends = new int[edgeCount];
        /**
         * 创建结果数组，保存最后的最小生成树
         */
        KEdge[] rets = new KEdge[this.vertexes.length - 1];
        KEdge[] edges = this.getEdges();
        this.sortEdges(edges);
        /**
         * 遍历所有的遍，将权值最小的加入到最小生成树中，并判断是否形成了回路，如果没有，再加入rets
         */
        for (int i = 0; i < edges.length; i++) {
            int p1 = this.getPosition(edges[i].start);
            int p2 = this.getPosition(edges[i].end);
            /**
             * 获取p1在已有的最小生成树中的终点
             */
            int m = getEnds(ends, p1);
            int n = getEnds(ends, p2);
            if (m != n) {
                /**
                 * 没有构成回路。设置m在已有最小生成树中的终点。不设置终点为自己，因为上述算法有v=ends[v]
                 */
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }
        System.out.println("最小生成树为：");
        System.out.println(Arrays.toString(rets));
    }
}

class KEdge {
    char start;
    char end;
    int weight;

    public KEdge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "KEdge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/10/2021 9:04 PM
 */
public class KruskalAlgorithm {
    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 16, 14},
                {12, 0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 10, 0, 3, 5, 6, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 0, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 4, 0, 2, 8},
                {16, 7, 6, Integer.MAX_VALUE, 2, 0, 9},
                {14, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, 9, 0}
        };
        KGraph graph = new KGraph(matrix, vertexes);
        graph.showGraph();
        KEdge[] edges = graph.getEdges();
        System.out.println(Arrays.toString(edges));
        graph.sortEdges(edges);
        System.out.println(Arrays.toString(edges));
        graph.kruskal();
    }
}
