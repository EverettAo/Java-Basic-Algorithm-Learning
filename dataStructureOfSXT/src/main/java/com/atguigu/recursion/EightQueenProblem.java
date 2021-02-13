package com.atguigu.recursion;

/**
 * @author Everett
 */
public class EightQueenProblem {
    private static int maxQueen = 8;
    private static int[] checkerboard = new int[maxQueen];
    private static int total = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println("共" + total + "种方案");
    }

    /**
     * 当放第n个皇后的时候，检测是否与之前放好的皇后冲突
     *
     * @param n:表示第n个皇后
     * @return true：不冲突；false：冲突
     */
    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            /**
             * 是否在同一列；是否在斜线上(abs(行之差)==abs(列之差)，刚好成一个方阵，即在对角线上)
             */
            if (checkerboard[i] == checkerboard[n] || Math.abs(n - i) == Math.abs(checkerboard[n] - checkerboard[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 放置第n个皇后
     * <p>
     * 最难理解的点：是check在循环里面调用check进行递归，所以把所有可行情况都尝试完了
     *
     * @param n:第n个皇后
     */
    public static void check(int n) {
        if (n == maxQueen) {
            /**
             * 已经放好了全部
             */
            total++;
            for (int ele : checkerboard) {
                System.out.printf("%d,",ele);
            }
            System.out.println();
            printCheckerboard();
            System.out.println();
            return;
        } else {
            /**
             * 依次放入皇后并判断是否冲突
             * 这里其实相当于每个皇后有8种尝试方案，如果放好了（不冲突——judge(n)），再放下一个
             */
            for (int i = 0; i < maxQueen; i++) {
                /**
                 * 先把当前皇后（第n个）放到该行的第i列
                 */
                checkerboard[n] = i;
                /**
                 * 检测是否冲突，如果不冲突，放下一个
                 * 如果冲突，将第n个皇后放在本行的后一个位置
                 */
                if (judge(n)) {
                    check(n + 1);
                }
            }
        }
    }

    /**
     * 输入皇后摆放的位置
     */
    public static void printCheckerboard() {
        for (int i = 0; i < checkerboard.length; i++) {
            for (int j = 0; j < checkerboard.length; j++) {
                if (j == checkerboard[i]) {
                    System.out.printf("+\t");
                } else {
                    System.out.printf("o\t");
                }
            }
            System.out.println();
        }
    }
}
