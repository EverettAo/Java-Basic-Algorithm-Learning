package com.atguigu.tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 为了让Node对象支持排序：比如Collections，往往需要让类实现一个Comparable接口
 */
class Node implements Comparable<Node> {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.val - o.val;
    }
}

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 33, 4, 5};
        Node root= createHuffmanTree(arr);
        preOrder(root);
    }

    /**
     * huffman编码是无损压缩——恢复时不会造成损失
     * @param arr
     * @return
     */
    public static Node createHuffmanTree(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int v : arr) {
            nodes.add(new Node(v));
        }
        while (nodes.size() > 1) {
            // 从小到大排序
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.val + right.val);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public static void preOrder(Node tree) {
        if (tree != null) {
            System.out.println(tree);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
}
