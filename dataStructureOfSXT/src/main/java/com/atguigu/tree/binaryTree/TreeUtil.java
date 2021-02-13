package com.atguigu.tree.binaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 用来记录指向节点的指针，方便在方法内部改变节点的指向
 * 主要小线索化时有用到
 */
class NodeBox {
    Node val;

    NodeBox() {
    }
}

/**
 * @author Everett
 */
public class TreeUtil {
    private static final Scanner scanner = new Scanner(System.in);

    /*****************************三种遍历的递归写法：begin*****************************/
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
    /*****************************三种遍历的递归写法：end*****************************/


    /*****************************三种遍历的非递归写法：begin*****************************/

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
    /*****************************三种遍历的非递归写法：end*****************************/

    /**
     * 层序遍历
     */
    public static void layerOrderBinaryTree(Node tree) {
        Queue<Node> queue = new LinkedList<>();
        if (tree == null) {
            return;
        }
        queue.offer(tree);
        Node node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 如果是叶子节点，直接删除，如果是非叶子节点，删除以该节点为根的子数（为了简单）
     */
    public static void simpleDeleteNodeInBinaryTree(Node tree, Node target) {
        if (tree == null) {
            return;
        }
        if (tree.val == target.val) {
            tree.val = null;
            tree.left = null;
            tree.right = null;
            System.out.println("查找的节点为根节点，无法直接删除，已将值设为null");
            return;
        } else {
            if (tree.left != null) {
                if (tree.left.val == target.val) {
                    System.out.println("已查找到目标节点");
                    tree.left = null;
                    return;
                } else {
                    simpleDeleteNodeInBinaryTree(tree.left, target);
                }
            }
            if (tree.right != null) {
                if (tree.right.val == target.val) {
                    System.out.println("已查找到目标节点");
                    tree.right = null;
                    return;
                } else {
                    simpleDeleteNodeInBinaryTree(tree.right, target);
                }
            }
        }
    }

    /**
     * 中序遍历的二叉树线索化
     *
     * @param tree
     */
    public static void inThreadBinaryTree(Node tree, NodeBox preBox) {
        if (tree != null) {
            inThreadBinaryTree(tree.left, preBox);
            if (tree.ltag == false) {
                tree.left = preBox.val;
            }
            if (preBox.val != null && preBox.val.rtag == false) {
                preBox.val.right = tree;
            }
            preBox.val = tree;
            inThreadBinaryTree(tree.right, preBox);
        }
    }

    public static void createInThreadBinaryTree(Node tree) {
        if (tree != null) {
            NodeBox preBox = new NodeBox();
            inThreadBinaryTree(tree, preBox);
        }
    }

    /**
     * 获取中序遍历的索引二叉树的第一个节点：最左下角节点）
     *
     * @param tree
     * @return
     */
    public static Node getFirstNodeOfInThreadedBinaryTree(Node tree) {
        if (tree != null) {
            while (tree.left != null) {
                tree = tree.left;
            }
            return tree;
        } else {
            return null;
        }
    }

    public static void inOrderOfInThreadedBinaryTree(Node tree) {
        Node first = getFirstNodeOfInThreadedBinaryTree(tree);
        while (first != null) {
            System.out.println(first);
            first = first.right;
        }
    }

    /**
     * 前序线索化二叉树
     */
    public static void preThreadBinaryTree(Node tree, NodeBox preBox) {
        if (tree != null) {
            if (tree.ltag == false) {
                tree.left = preBox.val;
            }
            if (preBox.val != null && preBox.val.rtag == false) {
                preBox.val.right = tree;
            }
            preBox.val = tree;
            if (tree.ltag == true) {
                preThreadBinaryTree(tree.left, preBox);
            }
            preThreadBinaryTree(tree.right, preBox);
        }
    }

    public static void createPreThreadBinaryTree(Node tree) {
        if (tree != null) {
            NodeBox preBox = new NodeBox();
            preThreadBinaryTree(tree, preBox);
        }
    }

    /**
     * 遍历前序线索化二叉树
     */
    public static void preOrderOfPreThreadedBinaryTree(Node tree) {
        if (tree != null) {
            System.out.println(tree);
            if (tree.ltag == true) {
                preOrderOfPreThreadedBinaryTree(tree.left);
            } else {
                preOrderOfPreThreadedBinaryTree(tree.right);
            }
        }
    }

    /**
     * 后序线索化
     */
    public static void postThreadBinaryTree(Node tree, NodeBox preBox) {
        if (tree != null) {
            if (tree.ltag == true) {
                postThreadBinaryTree(tree.left, preBox);
            }
            if (tree.rtag == true) {
                postThreadBinaryTree(tree.right, preBox);
            }
            if (tree.ltag == false) {
                tree.left = preBox.val;
            }
            if (preBox.val != null && preBox.val.rtag == false) {
                preBox.val.right = tree;
            }
            preBox.val = tree;
        }
    }

    public static void createPostThreadBinaryTree(Node tree) {
        if (tree != null) {
            NodeBox preBox = new NodeBox();
            postThreadBinaryTree(tree, preBox);
        }
    }

    /**
     * 后序线索二叉树的遍历
     */
    public static void postOrderOfPostThreadedBinaryTree(Node tree) {
        if (tree != null) {
            if (tree.ltag == true) {
                postOrderOfPostThreadedBinaryTree(tree.left);
            }
            if (tree.rtag == false) {
                System.out.println(tree);
            } else {
                postOrderOfPostThreadedBinaryTree(tree.right);
                System.out.println(tree);
            }
        }
    }
}