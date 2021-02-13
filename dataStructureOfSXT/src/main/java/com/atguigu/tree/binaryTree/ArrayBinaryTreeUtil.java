package com.atguigu.tree.binaryTree;

/**
 * 这里假设数组直接为int类型
 * 二叉树的顺序存储通常是针对完全二叉树，故这里以完全二叉树为例
 */
public class ArrayBinaryTreeUtil {
    public static void preOrderRec(int[] tree, int index) {
        if (tree == null || tree.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.println(tree[index]);
        if (index * 2 + 1 < tree.length) {
            preOrderRec(tree, index * 2 + 1);
        }
        if (index * 2 + 2 < tree.length) {
            preOrderRec(tree, index * 2 + 2);
        }
    }
    public static void inOrderRec(int[] tree, int index) {
        if (tree == null || tree.length == 0) {
            System.out.println("数组为空");
            return;
        }
        if (index * 2 + 1 < tree.length) {
            inOrderRec(tree, index * 2 + 1);
        }
        System.out.println(tree[index]);
        if (index * 2 + 2 < tree.length) {
            inOrderRec(tree, index * 2 + 2);
        }
    }
    public static void postOrderRec(int[] tree, int index) {
        if (tree == null || tree.length == 0) {
            System.out.println("数组为空");
            return;
        }
        if (index * 2 + 1 < tree.length) {
            postOrderRec(tree, index * 2 + 1);
        }
        if (index * 2 + 2 < tree.length) {
            postOrderRec(tree, index * 2 + 2);
        }
        System.out.println(tree[index]);
    }
}
