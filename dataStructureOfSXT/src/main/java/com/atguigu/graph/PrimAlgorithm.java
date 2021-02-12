package com.atguigu.graph;

import java.util.Arrays;

class PGraph {
    int vertextCount;   // 节点数
    char[] data;    // 节点数据
    int[][] weight;     // 存放边——邻接矩阵

    public PGraph(int vertextCount) {
        this.vertextCount = vertextCount;
        data = new char[vertextCount];
        weight = new int[vertextCount][vertextCount];
    }
}

/**
 * 创建最小生成树
 */
class MinTree {
    /**
     * @param graph       图对象
     * @param vertexCount 图的顶点个数
     * @param data        图的顶点值
     * @param weight      图的邻接矩阵
     */
    public void createGraph(PGraph graph, int vertexCount, char[] data, int[][] weight) {
        for (int i = 0; i < vertexCount; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertexCount; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 打印图的邻接矩阵
     *
     * @param graph
     */
    public void showGraph(PGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 从图的第v个顶点开始利用普里姆算法生成最小生成树
     *
     * @param graph 图
     * @param v     开始顶点
     */
    public void prim(PGraph graph, int v) {
        /**
         * 标记节点是否被访问过。默认元素的值都是0，表示未被访问过
         */
        int[] visited = new int[graph.vertextCount];
        /**
         * 这一步可以不写（默认初始化）——初始化数组
         */
        Arrays.fill(visited, 0);
        visited[v] = 1;
        /**
         * h1、h2记录边关联的两个顶点的下标
         */
        int h1 = -1, h2 = -1;
        /**
         * 初始化miniWeight，在遍历过程中会被替换
         */
        int miniWeight = 10000;
        /**
         * 因为有vertexCount个顶点，普里姆算法结束后有vertexCount-1条边
         */
        for (int k = 1; k < graph.vertextCount; k++) {  // 生成边
            for (int i = 0; i < graph.vertextCount; i++) {  // 访问已访问的节点，从中选出一个起始点来生成边
                for (int j = 0; j < graph.vertextCount; j++) {  // 访问未访问的节点，从中选出一个末尾点来与i生成边
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < miniWeight) {
                        miniWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                } // for j，找到了一条边
            } // for i
            visited[h2] = 1;
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">  权值：" + graph.weight[h1][h2]);
            miniWeight = 10000;
        }
    }
}

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/10/2021 7:16 PM
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexCount = data.length;
        /**
         * 权值很大（10000）表示不连通
         */
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };

        PGraph graph = new PGraph(vertexCount);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertexCount, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }
}