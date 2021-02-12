package com.atguigu.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/7/2021 8:38 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
class Graph {
    private ArrayList<String> vertexList; // 顶点集合
    private int[][] edges; // 记录边的情况
    private int numOfEdge;
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        isVisited = new boolean[n];
        numOfEdge = 0;
    }

    /**
     * 插入顶点
     *
     * @param str 顶点的内容
     */
    public void insertVertex(String str) {
        vertexList.add(str);
    }

    /**
     * 插入边
     *
     * @param v1     顶点的下标
     * @param v2     顶点的下标
     * @param weight 边的权重
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdge++;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdge() {
        return numOfEdge;
    }

    public String getNodeByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] o : edges) {
            for (int i : o) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    /**
     * 得到第一个邻接节点的下标
     *
     * @param v 顶点
     * @return
     */
    public int getFirstNeighbor(int v) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[v][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标
     *
     * @param v1 目标节点
     * @param v2 目标节点前一个邻接节点
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     *
     * @param isVisited
     * @param i
     */
    private void deepFirstSearch(boolean[] isVisited, int i) {
        System.out.print(getNodeByIndex(i) + "->");
        isVisited[i] = true;
        for (int w = getFirstNeighbor(i); w != -1; w = getNextNeighbor(i, w)) {
            if (!isVisited[w]) {
                deepFirstSearch(isVisited, w);
            }
        }
    }

    public void deepFirstSearch() {
        Arrays.fill(isVisited, false);  // 初始化数组
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                deepFirstSearch(isVisited, i);
            }
        }
        System.out.println();
    }

    /**
     * 广度优先遍历
     *
     * @param v 第一个要访问的节点
     */
    private void broadFirstSearch(boolean[] isVisited, int v, LinkedList<Integer> queue) {
        System.out.print(getNodeByIndex(v) + "->");
        isVisited[v] = true;
        queue.addLast(v);
        while (!queue.isEmpty()) {
            v = queue.removeFirst();
            for (int w = getFirstNeighbor(v); w != -1; w = getNextNeighbor(v, w)) {
                if (!isVisited[w]) {
                    System.out.print(getNodeByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
            }
        }
    }

    public void broadFirstSearch() {
        Arrays.fill(isVisited, false);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                broadFirstSearch(isVisited, i, queue);
            }
        }
        System.out.println();
    }

    /**
     * 利用广度优先搜索求解单源最短路径
     * @param v 起始节点
     */
    public void bfsMinDistance(int v) {
        int[] d = new int[vertexList.size()];
        Arrays.fill(d, 0);
        Arrays.fill(isVisited, false);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(v);
        isVisited[v] = true;
        while (!queue.isEmpty()) {
            v = queue.removeLast();
            for (int w = getFirstNeighbor(v); w != -1; w = getNextNeighbor(v, w)) {
                if (!isVisited[w]) {
                    isVisited[w] = true;
                    d[w] = d[v] + 1;
                    queue.addLast(w);
                }
            }
        }
        System.out.println(Arrays.toString(d));
    }
}
