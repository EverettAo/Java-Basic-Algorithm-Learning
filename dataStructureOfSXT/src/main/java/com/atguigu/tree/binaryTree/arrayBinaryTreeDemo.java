package com.atguigu.tree.binaryTree;

public class arrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] tree = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("前序：");
        ArrayBinaryTreeUtil.preOrderRec(tree, 0);
        System.out.println("中序：");
        ArrayBinaryTreeUtil.inOrderRec(tree, 0);
        System.out.println("后序：");
        ArrayBinaryTreeUtil.postOrderRec(tree, 0);
    }
}
