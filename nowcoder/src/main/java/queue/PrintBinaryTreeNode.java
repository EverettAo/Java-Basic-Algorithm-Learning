package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PrintBinaryTreeNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rl = new TreeNode(2);
        TreeNode rr = new TreeNode(3);
        TreeNode rll = new TreeNode(4);
        TreeNode rlr = new TreeNode(5);
        TreeNode rlrr = new TreeNode(6);
        root.left = rl;
        root.right = rr;
        rl.left = rll;
        rl.right = rlr;
        rr.right = rlrr;
        System.out.println(PrintFromTopToBottom(root));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
