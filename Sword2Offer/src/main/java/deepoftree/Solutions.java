package deepoftree;
/**
 * @author Everett
 * @date 2021-03-06 11:10 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/6/2021 11:10 PM
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solutions {
    public static void main(String[] args) {

    }

    public static int solution_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode t;
        int dp = 1;
        int count = 0, nextCount = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            t = queue.poll();
            count++;
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
            if (count == nextCount) {
                dp++;
                count = 0;
                nextCount = queue.size();
            }
        }
        return dp;
    }

    private static int solution_2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(solution_2(root.left), solution_2(root.right)) + 1;
        }
    }
}
