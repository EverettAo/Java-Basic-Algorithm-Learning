package com.atguigu.tree.binaryTree;

public class binaryTreeDemo {
    public static void demo1(Node<Integer> node) {
        node.val = 4;
    }

    public static void demo2(Node<Integer> node) {
        node = new Node(111);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rl = new Node<>(2);
        Node<Integer> rr = new Node<>(3);
        Node<Integer> rll = new Node<>(4);
        Node<Integer> rlr = new Node<>(5);
        Node<Integer> rlrr = new Node<>(6);
        root.left = rl;
        root.right = rr;
        root.ltag = true;
        root.rtag = true;
        rl.left = rll;
        rl.right = rlr;
        rl.ltag = true;
        rl.rtag = true;
        rlr.right = rlrr;
        rlr.rtag = true;

//        Node t1 = root, t2 = root, t3 = root, t4 = root, t5 = root, t6 = root;

/*        System.out.println("preRec:");
        TreeUtil.preOrderBinaryTreeRec(t1);
        System.out.println("pre:");
        TreeUtil.preOrderBinaryTree(t4);

        System.out.println("inRec:");
        TreeUtil.inOrderBinaryTreeRec(t2);
        System.out.println("in:");
        TreeUtil.inOrderBinaryTree(t5);

        System.out.println("postRec:");
        TreeUtil.postOrderBinaryTreeRec(t3);
        System.out.println("post:");
        TreeUtil.postOrderBinaryTree(t6);*/
        /*TreeUtil.layerOrderBinaryTree(root);
        System.out.println("delete:" + rl.val);
        TreeUtil.simpleDeleteNodeInBinaryTree(root, rlrr);
        TreeUtil.preOrderBinaryTree(root);*/

        TreeUtil.createPostThreadBinaryTree(root);
        TreeUtil.postOrderOfPostThreadedBinaryTree(root);
/*        Node<Integer> integerNode = new Node<>(1);
        System.out.println(integerNode);
        demo1(integerNode);
        System.out.println(integerNode);
        demo2(integerNode);
        System.out.println(integerNode);*/
    }
}
