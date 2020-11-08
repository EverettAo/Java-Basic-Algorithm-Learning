package com.atguigu.search.fibSearch;

import java.util.Arrays;

public class fibSearch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib(10)));
    }

    /**
     * 得到斐波拉契数列
     *
     * @param max：数列长度
     */
    public static int[] fib(int max) {
        int fibs[] = new int[max];
        fibs[0] = 1;
        fibs[1] = 1;
        if (max == 1 || max == 2) {
            return fibs;
        } else {
            for (int i = 2; i < max; i++) {
                fibs[i] = fibs[i - 1] + fibs[i - 2];
            }
            return fibs;
        }
    }


    public static int fibSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        /**
         * 斐波那契分割数值对应的下标
         */
        int k;
        int[] fibs = fib(key);
        return 0;
    }

    public static int goldSplitSearch(int[] arr, int key) {
        return 0;
    }
}
