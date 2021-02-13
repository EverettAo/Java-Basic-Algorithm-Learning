package com.atguigu.tree.binaryTree;

import java.util.Objects;

class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;
    boolean ltag, rtag; // 线索化二叉树使用，true表示指向子节点，false表示指向前驱

    Node(T val) {
        this.val = val;
    }

    Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return val.equals(node.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}