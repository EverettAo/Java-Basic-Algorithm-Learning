package isbalance;
/**
 * @author Everett
 * @date 2021-03-06 11:28 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/6/2021 11:28 PM
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

    public static boolean solution_1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else {
            int l = getHeight(root.left), h = getHeight(root.right);
            if (Math.abs(l - h) > 1) {
                return false;
            } else {
                return solution_1(root.left) && solution_1(root.right);
            }
        }
    }

    private static int getHeight(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else {
            return Math.max(getHeight(tree.left), getHeight(tree.right)) + 1;
        }
    }

    public static boolean solution_2(TreeNode root) {
        return Height(root) != -1;
    }

    private static int Height(TreeNode tree) {
        if (tree == null) return 0;
        int l = Height(tree.left);
        if (l == -1) return -1;
        int r = Height(tree.right);
        if (r == -1) return -1;
        return Math.abs(l - r) > 1 ? -1 : 1 + Math.max(l, r);
    }
}
