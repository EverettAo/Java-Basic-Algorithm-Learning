package com.atguigu.sort.shellSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class shellSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        exchangeShellSort(arr);
//        moveShellSort(arr);
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt();
            nums[i] = r;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        moveShellSort(nums);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
    }

    /**
     * 交换法
     *
     * @param arr
     */
    public static void exchangeShellSort(int[] arr) {
        int ex;
        /**
         * 要分多少次组
         */
        for (int steplen = arr.length / 2; steplen > 0; steplen /= 2) {
            /**
             * 每次（多组同时进行）组内的排序：两层循环
             * 外层：arr.length-steplen次（当steplen=1，退化为普通的插入排序）
             * 内层：每次和前面已经排好序的数进行比较，采用插入排序
             */
            for (int i = steplen; i < arr.length; i++) {
                for (int j = i - steplen; j >= 0; j -= steplen) {
                    if (arr[j] > arr[j + steplen]) {
                        ex = arr[j];
                        arr[j] = arr[j + steplen];
                        arr[j + steplen] = ex;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 移位法
     *
     * @param arr
     */
    public static void moveShellSort(int[] arr) {
        int ex;
        int curIndex;
        int curEle;
        for (int steplen = arr.length / 2; steplen > 0; steplen /= 2) {
            /**
             * 从第steplen个元素，对其所在的组直接进行插入排序
             */
            for (int i = steplen; i < arr.length; i++) {
                curIndex = i;
                curEle = arr[i];
                /**
                 * 其实不加if也行，为什么要加？减少while之后的赋值
                 */
                if (arr[curIndex] < arr[curIndex - steplen]) {
                    while (curIndex >= steplen && curEle < arr[curIndex - steplen]) {
                        arr[curIndex] = arr[curIndex - steplen];
                        curIndex -= steplen;
                    }
                    arr[curIndex] = curEle;
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
    }
}
