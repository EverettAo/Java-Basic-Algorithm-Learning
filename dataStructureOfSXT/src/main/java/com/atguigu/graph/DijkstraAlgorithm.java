package com.atguigu.graph;

import java.util.Arrays;

class DGraph {
    char[] vertexes;    // 顶点数组
    int[][] matrix;     // 邻接矩阵
    VisitedVertexes vv;

    public DGraph(char[] vertexes, int[][] matrix) {
        this.vertexes = Arrays.copyOf(vertexes, vertexes.length);
        this.matrix = new int[vertexes.length][vertexes.length];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }

    public void showGraph() {
        for (int[] line : this.matrix) {
            System.out.println(Arrays.toString(line));
        }
    }

    /**
     * @param index 出发顶点的下标
     */
    public void dijkstra(int index) {
        this.vv = new VisitedVertexes(this.vertexes.length, index);
        this.update(index);
        for (int i = 1; i < this.vertexes.length; i++) {
            index = this.vv.updateArray();
            update(index);
        }
    }

    /**
     * 显示最后的结果
     */
    public void showArrays() {
        System.out.println("already_arr：" + Arrays.toString(this.vv.already_arr));
        System.out.println("pre_array：" + Arrays.toString(this.vv.pre_visited));
        System.out.println("dis：" + Arrays.toString(this.vv.dis));
    }

    /**
     * 更新顶点到周围顶点的距离以及前驱节点
     *
     * @param index
     */
    private void update(int index) {
        /**
         * len的含义：出发顶点到顶点index的距离加上index顶点到顶点i的距离之和
         */
        int len = 0;
        /**
         * 根据遍历邻接矩阵的index行，来进行更新
         */
        for (int i = 0; i < this.matrix[index].length; i++) {
            len = this.vv.getDis(index) + this.matrix[index][i];
            /**
             * 如果顶点i没有被访问过且len<源点到i顶点的距离，则更新
             */
            if (!vv.in(i) && len < this.vv.getDis(i)) {
                this.vv.updateDis(i, len);
                this.vv.updatePre(i, index);
            }
        }
    }
}

/**
 * 已访问顶点集合
 */
class VisitedVertexes {
    /**
     * 记录各个顶点是否被访问过，被访问过记为1，未访问过记为0
     */
    public int[] already_arr;
    /**
     * 前驱节点下标
     */
    public int[] pre_visited;
    /**
     * 起始点到其他顶点的距离
     */
    public int[] dis;

    public VisitedVertexes(int length, int originVertex) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        this.already_arr[originVertex] = 1;
        Arrays.fill(this.dis, 65535);
        this.dis[originVertex] = 0;
    }

    /**
     * 判断顶点是否被访问过
     *
     * @param index
     * @return
     */
    public boolean in(int index) {
        return this.already_arr[index] != 0;
    }

    /**
     * 更新出发顶点到index顶点的距离，注意，在调用此方法之前需要进行判断
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        this.dis[index] = len;
    }

    /**
     * 更新节点前驱，注意，这个方法与老师视频讲的参数意义不一致。但是调用是一样的，更新第一个参数的前驱为第二个参数
     *
     * @param index
     * @param pre
     */
    public void updatePre(int index, int pre) {
        this.pre_visited[index] = pre;
    }

    /**
     * 返回源点到index顶点的距离
     *
     * @param index
     * @return
     */
    public int getDis(int index) {
        return this.dis[index];
    }

    /**
     * 继续选择新的顶点作为已访问顶点
     *
     * @return
     */
    public int updateArray() {
        int min = 65535;
        int index = 0;
        for (int i = 0; i < this.already_arr.length; i++) {
            if (this.already_arr[i] == 0 && this.dis[i] < min) {
                min = this.dis[i];
                index = i;
            }
        }
        this.already_arr[index] = 1;
        return index;
    }
}

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/11/2021 11:43 AM
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertexes.length][vertexes.length];
        final int N = 65535;    // 表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        DGraph graph = new DGraph(vertexes, matrix);
        graph.showGraph();
        graph.dijkstra(2);
        graph.showArrays();
    }
}
