package queue;

/*class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}*/

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
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
    }

    String Serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + ",");
            } else {
                sb.append("#,");
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] list = str.split(",");
        TreeNode[] nodes = new TreeNode[list.length];
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals("#")) {
                nodes[i] = new TreeNode(Integer.parseInt(list[i]));
            }
        }
        for (int i = 0, j = 1; j < nodes.length; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[j++];
                nodes[i].right = nodes[j++];
            }
        }
        return nodes[0];
    }
}
