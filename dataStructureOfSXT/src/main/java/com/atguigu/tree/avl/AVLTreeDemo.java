package com.atguigu.tree.avl;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 1/30/2021 5:31 PM
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

    /**
     * 在以本节点为根的树（默认本节点不为null）中添加节点，注意，在avl树中，添加节点时要注意对树进行调整
     *
     * @param node 要搜索的节点
     */
    public void addNode(Node node) {
        if (node != null) {
            if (this.data <= node.data) {// 注意：是大于等于都加到了右边
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.addNode(node);
                }
            } else {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.addNode(node);
                }
            }
            if (this.getRightHeight() - this.getLeftHeight() > 1) {
                if (this.right != null && this.right.getLeftHeight() > this.right.getRightHeight()) {
                    this.right.rightRotate();
                }
                this.leftRotate();
                return; // 强烈建议写上，一是避免后续的不必要判断；二是避免后面出现意外
            }
            if (this.getLeftHeight() - this.getRightHeight() > 1) {
                if (this.left != null && this.left.getRightHeight() > this.left.getLeftHeight()) {
                    this.left.leftRotate();
                }
                this.rightRotate();
            }
        }
    }

    /**
     * 在以本节点为根的树中搜索目标节点
     *
     * @param target 目标节点的data值
     * @return 搜索到的节点
     */
    public Node searchNode(int target) {
        if (this.data == target) {
            if (this.right != null && this.right.data == target) {  // 注意考虑等于的情况
                return this.right.searchNode(target);
            } else {
                return this;
            }
        } else if (this.data < target) {
            if (this.right == null) {
                return null;
            } else {
                return this.right.searchNode(target);
            }
        } else {
            if (this.left == null) {
                return null;
            } else {
                return this.left.searchNode(target);
            }
        }
    }

    /**
     * 查找目标节点的父节点，默认不对树的根节点调用本方法
     *
     * @param target 目标节点值
     * @return 目标节点的父节点
     */
    public Node searchParentNode(int target) {
        if ((this.left != null && this.left.data == target)
                || (this.right != null && this.right.data == target)) {
            return this;
        } else {
            if (this.data >= target && this.left != null) {
                return this.left.searchParentNode(target);
            } else if (this.data < target && this.right != null) {
                return this.right.searchParentNode(target);
            } else {
                return null;
            }
        }
    }

    /**
     * 返回以当前节点为根的树的高度
     */
    public int getHeight() {
        return Math.max((this.right == null) ? 0 : this.right.getHeight(), (this.left == null) ? 0 : this.left.getHeight()) + 1;
    }

    /**
     * 返回左子树的高度
     */
    public int getLeftHeight() {
        return this.left == null ? 0 : this.left.getHeight();
    }

    /**
     * 返回右子树的高度
     */
    public int getRightHeight() {
        return this.right == null ? 0 : this.right.getHeight();
    }

    /**
     * 中序遍历avl树，假设根节点不为空——由avltree这个类保障
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 技巧：不方便更改引用时，更改他的值
     */
    public void leftRotate() {
        Node node = new Node(this.data);
        node.left = this.left;
        node.right = this.right.left;
        this.data = this.right.data;
        this.right = this.right.right;
        this.left = node;
    }

    public void rightRotate() {
        Node node = new Node(this.data);
        node.right = this.right;
        node.left = this.left.right;
        this.data = this.left.data;
        this.left = this.left.left;
        this.right = node;
    }
}

/**
 * @author Everett
 * @version 1.0
 * @description AVLTree其实相当于对Node进行了一层封装，以方便操作
 * @time 2/5/2021 12:16 AM
 */
class AVLTree {
    /**
     * avltree的根节点
     */
    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("null");
        }
    }

    /**
     * 往avltree中添加节点，注意，avltree的调整在Node中完成
     *
     * @param node 要添加的节点
     * @return 树的根
     */
    public Node addNode(Node node) {
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.addNode(node);
        }
        return this.root;
    }

    /**
     * 根据值查找节点
     *
     * @param target 要查找的目标值
     * @return 查找到的节点
     */
    public Node searchNode(int target) {
        if (this.root != null) {
            return this.root.searchNode(target);
        } else {
            return null;
        }
    }

    /**
     * 查找父节点：一定存在，如果为null，则表示目标节点为根节点
     *
     * @param target
     * @return
     */
    public Node searchParentNode(int target) {
        if (this.root != null) {
            if (this.root.data == target) {
                return null;
            } else {
                return this.root.searchParentNode(target);
            }
        } else {
            return null;
        }
    }

    /**
     * 在以node为根的子树中查找并删除最小的的节点
     *
     * @param node 根节点
     * @return 最小节点
     */
    public Node findDeleteMinNode(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.data);
        return target;
    }

    /**
     * 主要是要考虑到删除节点为根节点的情况
     * * 分三种情况：
     * * 1. 目标节点无子节点：直接删除
     * * 2. 目标节点有一个子节点：让其父节点直接指向目标节点的子节点
     * * 3. 目标节点有两个子节点：用右子树中的最小的节点代替目标节点
     *
     * @param target 要删除的目标节点的值
     * @return 被删除的节点
     */
    public Node deleteNode(int target) {
        if (this.root == null) {
            return null;
        } else {
            Node targetNode = this.searchNode(target);
            if (targetNode == null) {   // 没有找到目标节点
                return null;
            }
            Node parentNode = this.searchParentNode(target);
            if (targetNode.left == null && targetNode.right == null) {  // 要删除的节点为叶子节点
                // 叶子节点
                if (targetNode == this.root) {
                    this.root = null;
                    return targetNode;
                }
                if (parentNode.left != null && parentNode.left == targetNode) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {   // 都不为空
                /**
                 * 直接改变节点的值，就不用考虑引用的改变
                 */
                Node minNode = findDeleteMinNode(targetNode.right);
                targetNode.data = minNode.data;
            } else {    // 有一个节点
                if (targetNode.left != null) {
                    if (targetNode != this.root) {
                        parentNode.left = targetNode.left;
                    } else {
                        this.root = targetNode.left;
                    }
                } else {
                    if (targetNode != this.root) {
                        parentNode.right = targetNode.right;
                    } else {
                        this.root = targetNode.right;
                    }
                }
            }
            return targetNode;
        }
    }
}

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10, 7, 11, 6, 8, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int ele : arr) {
            avlTree.addNode(new Node(ele));
        }
        /*avlTree.deleteNode(12);
        avlTree.deleteNode(7);
        avlTree.infixOrder();
        for (int ele : arr) {
            avlTree.deleteNode(ele);
        }
        avlTree.infixOrder();
        System.out.println("________________________________");
        */
        System.out.println("根节点为：" + avlTree.getRoot());
        System.out.println("左子树的高度：" + avlTree.getRoot().getLeftHeight());
        System.out.println("右子树的高度：" + avlTree.getRoot().getRightHeight());
        System.out.println("根节点的左子节点：" + avlTree.getRoot().left);
        System.out.println("根节点的右子节点：" + avlTree.getRoot().right);
    }
}
