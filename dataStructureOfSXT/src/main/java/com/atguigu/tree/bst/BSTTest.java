package com.atguigu.tree.bst;

/**
 * @author Everett
 * @version 1.0
 * @description 二叉排序树
 * @date 1/29/2021 10:50 AM
 */

class Node implements Comparable<Node> {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.data - o.data;
    }
}

public class BSTTest {
    public static void main(String[] args) {
        /*Node root = new Node((int) (Math.random() * 10));
        for (int i = 0; i < 5; i++) {
            Node node = new Node((int) (Math.random() * 10));
            addNode2BST(root, node);
        }*/
        int[] arr = new int[]{5, 2, -11, 23, 7, 33, 10, 30};
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            addNode2BST(root, new Node(arr[i]));
        }
        inOrder(root);
        Node node = searchNode(root, 2);
        if (node != null) {
            System.out.println(node);
            System.out.println(node.left);
            System.out.println(node.right);
        }
        System.out.println("********************************************");
        Node res = deleteNode(root, null, 5);
        System.out.println(res);
        System.out.println("****************after delete****************");
        inOrder(root);
    }

    public static void addNode2BST(Node root, Node node) {
        if (node != null) {
            if (root.data < node.data) {
                if (root.right == null) {
                    root.right = node;
                } else {
                    addNode2BST(root.right, node);
                }
            } else {
                if (root.left == null) {
                    root.left = node;
                } else {
                    addNode2BST(root.left, node);
                }
            }
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }

    public static Node searchNode(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;
        } else if (root.data > target) {
            return searchNode(root.left, target);
        } else {
            return searchNode(root.right, target);
        }
    }

    /**
     * 1. 找到targetNode，找到targetNode的parent节点
     * <p>
     * 如果target是叶子节点：直接删除
     * 2. 确定targetNode是左子节点还是右子节点
     * <p>
     * 如果target只有一棵子树：
     * 3. 确定targetNode的子节点是左子节点还是右子节点
     * 3.1 targetNode有左子节点：
     * 3.1.1 如果targetNode是parentNodde左子节点:
     * parent.left = target.left
     * 3.1.2 如果targetNode是parentNodde右子节点:
     * parent.right = target.left
     * 3.2 targetNode有右子节点：
     * 3.2.1 如果target是parent的左子节点：
     * 3.3.3 如果target是parent的右子节点：
     * <p>
     * 如果target有两颗子树：
     * 3.3 找到右子节点中最小的节点(右子树中最左边的节点)，用其来代替target
     *
     * @return
     * @description 删除节点
     * @params
     * @author Everett
     * @time 1/29/2021 11:35 AM
     */
    public static Node deleteNode(Node root, Node parent, int target) {
        /**
         * 先找到该节点，过程中要注意保存其父节点
         * 三种情况：无子树，一棵子树，两棵子树
         */
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            // case1：无子树，直接删除
            Node res = new Node(root.data);
            if (root.left == null && root.right == null) {
                if (parent == null) {
                    System.out.println("该二叉排序树只一个跟节点且该节点为查找目标，无法直接删除");
                } else {
                    if (parent.left == root) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } // if &&
            else if (root.left != null && root.right != null) {
                // 左右子树都存在，取右子树中的最小值
                Node rightMinNodeParent = root;
                Node rightMinNode = root.right;
                while (rightMinNode.left != null) {
                    rightMinNodeParent = rightMinNode;
                    rightMinNode = rightMinNode.left;
                }
                // 找到了右子树中的最左边节点
                if (rightMinNodeParent.left == rightMinNode) {
                    rightMinNodeParent.left = rightMinNode.right;
                } else if (rightMinNodeParent.right == rightMinNode) {
                    rightMinNodeParent.right = rightMinNode.right;
                }
                root.data = rightMinNode.data;
            } // else if &&
            else { // 只有一棵子树
                // root有左子树
                if (root.left != null) {
                    if (parent.left == root) {
                        parent.left = root.left;
                    }
                    if (parent.right == root) {
                        parent.right = root.left;
                    }
                }
                // root有右子树
                else {
                    if (parent.left == root) {
                        parent.left = root.right;
                    }
                    if (parent.right == root) {
                        parent.right = root.right;
                    }
                }
            } // else
            return res;
        } // if(root.data == target)
        else if (root.data < target) {
            return deleteNode(root.right, root, target);
        } // else if(root.data < target
        else {
            return deleteNode(root.left, root, target);
        } // else
    }
}
