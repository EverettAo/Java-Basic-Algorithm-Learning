package com.atguigu.tree.binaryTree;


import java.util.Scanner;
import java.util.Stack;

/**
 * @author Everett
 */
public class treeUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static void preOrderBinaryTreeRec(Node root) {
        if (root != null) {
            System.out.println(root);
            preOrderBinaryTreeRec(root.left);
            preOrderBinaryTreeRec(root.right);
        }
    }

    public static void inOrderBinaryTreeRec(Node root) {
        if (root != null) {
            inOrderBinaryTreeRec(root.left);
            System.out.println(root);
            inOrderBinaryTreeRec(root.right);
        }
    }

    public static void postOrderBinaryTreeRec(Node root) {
        if (root != null) {
            postOrderBinaryTreeRec(root.left);
            postOrderBinaryTreeRec(root.right);
            System.out.println(root);
        }
    }

    public static void preOrderBinaryTree(Node root) {
        Stack<Node> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                System.out.println(root);
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
    }

    public static void inOrderBinaryTree(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root);
                root = root.right;
            }
        }
    }

    public static void postOrderBinaryTree(Node root) {
        Stack<Node> stack = new Stack<>();
        Node lastVisited = null;    // lastVisited来记录上次访问的节点
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek();
                if (root.right != null && lastVisited != root.right) {
                    root = root.right;
                    /**
                     * 以下两行可省，因为能够回到最上面的if
                     */
//                    stack.push(root);
//                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root);
                    lastVisited = root;
                    // 为什么root访问之后要置为null？让其继续从栈中取元素，防止while时又将其入栈
                    root = null;
                }
            }
        }
    }
}