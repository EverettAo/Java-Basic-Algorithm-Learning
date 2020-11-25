package com.atguigu.tree.binaryTree;

class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    Node(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}