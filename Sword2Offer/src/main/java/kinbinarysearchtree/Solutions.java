package kinbinarysearchtree;
/**
 * @author Everett
 * @date 2021-03-07 12:05 AM
 */

import java.util.Stack;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/7/2021 12:05 AM
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

    private static TreeNode solution_1(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        int count = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                count++;
                if (count == k) {
                    return p;
                }
                p = p.right;
            }
        }
        return null;
    }
}
