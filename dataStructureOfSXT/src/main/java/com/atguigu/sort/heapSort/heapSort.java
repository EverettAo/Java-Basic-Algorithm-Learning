package com.atguigu.sort.heapSort;

/**
 * 注意：数组的0位没有使用
 * 堆排序只能是对完全二叉树的顺序存储而言
 */
public class heapSort {

    public static void buildMaxHeap(int[] heapArray) {
        /**
         * 从最后一个非叶子节点向下调整
         */
        for (int i = heapArray.length / 2; i > 0; i--) {
            HeadAdustOfMaxHeap(heapArray, i, heapArray.length - 1);
        }
    }

    /**
     * 向下调整子堆
     * 用0位暂存子堆的根节点
     * 子根节点i的子节点为：i*2, i*2+1 -->见二叉树的顺序存储
     *
     * @param heapArray 堆数组
     * @param subRoot   子堆根的索引
     * @param len       堆的长度
     */
    private static void HeadAdustOfMaxHeap(int[] heapArray, int subRoot, int len) {
        heapArray[0] = heapArray[subRoot];
        for (int i = subRoot * 2; i <= len; i *= 2) {
            // 取较大子节点的下标
            if (i <= len && i + 1 <= len && heapArray[i] < heapArray[i + 1]) {
                i++;
            }
            // 因为是从最后的非叶子节点开始调整的，所以在后续的调整中，一遇到下述情况，即表示调整该结束
            if (heapArray[0] >= heapArray[i]) {
                break;
            } else {
                heapArray[subRoot] = heapArray[i];
                subRoot = i;    // 保证向下调整的继续
            }
        }
        heapArray[subRoot] = heapArray[0];
    }

    public static void printMaxKEleInMaxHeap(int[] heapArray, int k) {
        buildMaxHeap(heapArray);
        int count = 0, i = heapArray.length - 1;
        for (; count < k && i > 1; i--) {
            System.out.printf(heapArray[1] + "\t");
            count++;
            heapArray[1] = heapArray[i];
            HeadAdustOfMaxHeap(heapArray, 1, i - 1);
        }
        if (i == 1 && count < k) {
            System.out.printf(heapArray[1] + "\t");
        }
    }
}
