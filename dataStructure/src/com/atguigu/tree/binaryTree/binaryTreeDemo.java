package com.atguigu.tree.binaryTree;

public class binaryTreeDemo {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rl = new Node<>(2);
        Node<Integer> rr = new Node<>(3);
        Node<Integer> rll = new Node<>(4);
        Node<Integer> rlr = new Node<>(5);
        Node<Integer> rlrr = new Node<>(6);
        root.left = rl;
        root.right = rr;
        rl.left = rll;
        rl.right = rlr;
        rr.right = rlrr;

        Node t1 = root, t2 = root, t3 = root, t4 = root, t5 = root, t6 = root;

        System.out.println("preRec:");
        treeUtil.preOrderBinaryTreeRec(t1);
        System.out.println("pre:");
        treeUtil.preOrderBinaryTree(t4);

        System.out.println("inRec:");
        treeUtil.inOrderBinaryTreeRec(t2);
        System.out.println("in:");
        treeUtil.inOrderBinaryTree(t5);

        System.out.println("postRec:");
        treeUtil.postOrderBinaryTreeRec(t3);
        System.out.println("post:");
        treeUtil.postOrderBinaryTree(t6);
    }
}
