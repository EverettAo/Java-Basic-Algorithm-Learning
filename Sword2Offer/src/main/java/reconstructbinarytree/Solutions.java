package reconstructbinarytree;
/**
 * @author Everett
 * @date 2021-03-03 12:53 AM
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Everett
 * @version 1.0
 * @description 根据前序遍历和中序遍历重建二叉树。ps：与树相关的算法基本都要用到递归
 * @date 3/3/2021 12:53 AM
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

public class Solutions {
    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        /**
         * 树的形状
         *                      3
         *                 9         20
         *                        15     7
         */
        System.out.println(Arrays.toString(HOrder(solution_1(preOrder, inOrder), 5)));
    }

    /**
     * @param pre
     * @param in
     * @return
     * @caution 与树相关的算法基本都要用到递归
     * @ac
     */
    public static TreeNode solution_1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        return createTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode createTree(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (pe < ps || ie < is) {
            return null;
        }
        if (is == ie) {
            return new TreeNode(in[is]);
        }
        int inPos = 0;
        while (pre[ps] != in[is + inPos]) {
            inPos++;
        }
        TreeNode root = new TreeNode(pre[ps]);
        root.left = createTree(pre, ps + 1, ps + inPos, in, is, is + inPos);
        root.right = createTree(pre, ps + inPos + 1, pe, in, is + inPos + 1, ie);
        return root;
    }

    private static int[] HOrder(TreeNode node, int n) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int[] intArray = new int[n];
        int i = 0;
        TreeNode temp;
        queue.offer(node);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            intArray[i++] = temp.val;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return intArray;
    }
}
