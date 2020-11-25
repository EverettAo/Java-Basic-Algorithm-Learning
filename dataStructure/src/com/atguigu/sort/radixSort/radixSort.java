package com.atguigu.sort.radixSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 基数排序，又叫桶排序，比快排还要快
 * 缺点：由于是按位放桶的，所以不能处理负数
 */
public class radixSort {
    public static void main(String[] args) {
//        int[] nums = new int[]{10, 1, 234, 19, 2352};
//        System.out.println(Arrays.toString(nums));
//        radixSort(nums);
//        System.out.println(Arrays.toString(nums));
        int[] nums = new int[8000000];
        for (int i = 0; i < nums.length; i++) {
            int r = (int)(Math.random()*8000000);
            nums[i] = r;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        radixSort(nums);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLen = (max + "").length();
        /**
         * 每个一维数组就是一个桶
         * 基数排序是“空间换时间”的经典算法
         */
        int[][] buckets = new int[10][arr.length];
        /**
         * 记录每个桶放了多少数组
         */
        int[] bucketIndexes = new int[10];
        int digit;
        for (int i = 0; i < maxLen; i++) {
            /**
             * 先对元素按位排序：分配
             * 注意：java中a^b这种方式计算次方并不准确
             */
            for (int j = 0; j < arr.length; j++) {
                digit = (int) (arr[j] / Math.pow(10, i) % 10);
                buckets[digit][bucketIndexes[digit]++] = arr[j];
            }
            /**
             * 收集
             */
            for (int j = 0, k = 0; j < buckets.length; j++) {
                /**
                 * 不能用如下方式收集，这种方式是按照桶中从上到下收集的。
                 * 因为分配arr是从前到后（按位有序），那么在桶上面的原则上来说应该是“大于”桶下面的元素的
                 * 所以如果从上到下收集，就无法正确的排序
                 *  while (bucketIndexes[j] > 0) {
                 *      arr[k++] = buckets[j][bucketIndexes[j]-- -1];
                 *  }
                 */

                if (bucketIndexes[j] != 0) {
                    for (int l = 0; l < bucketIndexes[j]; l++) {
                        arr[k++] = buckets[j][l];
                    }
                }
                /**
                 * 清0
                 */
                bucketIndexes[j] = 0;
            }
        }
    }
}
