package dynamicPlanning;

/**
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为 O(n).
 * <p>
 * demo:
 * input: [1,-2,3,10,-4,7,2,-5]
 * output: 18
 */
public class greatestSumOfSubArray {
    public static void main(String[] args) {

    }

    /**
     *  使用动态规划
     *
     * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     * F（i）=max（F（i-1）+array[i] ， array[i]）
     * res：所有子数组的和的最大值
     * res=max（res，F（i））
     * 如数组[6, -3, -2, 7, -15, 1, 2, 2]
     *
     * 初始状态：
     *     F（0）=6
     *     res=6
     * i=1：
     *     F（1）=max（F（0）-3，-3）=max（6-3，3）=3
     *     res=max（F（1），res）=max（3，6）=6
     * i=2：
     *     F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
     *     res=max（F（2），res）=max（1，6）=6
     * i=3：
     *     F（3）=max（F（2）+7，7）=max（1+7，7）=8
     *     res=max（F（2），res）=max（8，6）=8
     * i=4：
     *     F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
     *     res=max（F（4），res）=max（-7，8）=8
     * 以此类推
     * 最终res的值为8
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        /**
         * gt:存储到array[i]时，已经存在的最大连续子数组的和，最新的值并不一定是最大的，最新的只是表示到最新的元素时当前最大的连续子数组的和
         * 遇到新的元素array[i+1]时，gt[i]表示到加上array[i]后的最大子数组的和
         * gt[i]+array[i+1]：如果大于gt[i]，表示加上array[i]后，子数组的和变大，则新的算上array[i+1]后的连续子数组
         */
        int[] gt = new int[array.length];
        int max = array[0];
        gt[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            gt[i] = gt[i - 1] + array[i];
            if (gt[i] < array[i]) {
                gt[i] = array[i];
            }
            if (gt[i] > max) {
                max = gt[i];
            }
        }
        return max;
    }
}
