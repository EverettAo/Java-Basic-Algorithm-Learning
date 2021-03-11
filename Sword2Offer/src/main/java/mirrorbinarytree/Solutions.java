package mirrorbinarytree;
/**
 * @author Everett
 * @date 2021-03-06 9:48 PM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/6/2021 9:48 PM
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

    private static TreeNode solution_1(TreeNode pRoot) {
        if (pRoot != null) {
            TreeNode node = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = node;
            solution_1(pRoot.left);
            solution_1(pRoot.right);
            return pRoot;
        } else {
            return null;
        }
    }
}
