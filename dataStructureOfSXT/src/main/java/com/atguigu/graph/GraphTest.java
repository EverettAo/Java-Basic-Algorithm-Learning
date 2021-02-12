package com.atguigu.graph;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/7/2021 8:34 AM
 */

public class GraphTest {
    public static void main(String[] args) {
        int n = 5;
        String[] vertexVavlue = {"a", "b", "c", "d", "e"};
        Graph graph = new Graph(n);
        for (String s : vertexVavlue) {
            graph.insertVertex(s);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 3, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(2, 4, 1);
        graph.showGraph();
        graph.deepFirstSearch();
        System.out.println();
        graph.broadFirstSearch();

        Graph sGraph = new Graph(8);
        String[] strs = {"1", "2", "3", "4", "5", "6", "7", "8"};
        for (String s : strs) {
            sGraph.insertVertex(s);
        }
        sGraph.insertEdge(0,1,1);
        sGraph.insertEdge(0,2,1);
        sGraph.insertEdge(1,3,1);
        sGraph.insertEdge(1,4,1);
        sGraph.insertEdge(3,7,1);
        sGraph.insertEdge(4,7,1);
        sGraph.insertEdge(2,5,1);
        sGraph.insertEdge(2,6,1);
        sGraph.insertEdge(5,6,1);
        sGraph.deepFirstSearch();
        sGraph.broadFirstSearch();
        sGraph.bfsMinDistance(2);
    }
}