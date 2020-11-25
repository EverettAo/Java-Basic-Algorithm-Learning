package com.atguigu.sort.quickSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class quickSort_everett {
    public static void main(String[] args) {
//        int[] numsArray = new int[]{3, 1, 11, -5, 23, 0, 99, -5, 10};
////        quickSortViaPartition(numsArray, 0, numsArray.length - 1);
////        System.out.println(Arrays.toString(numsArray));
        int[] nums = new int[8000000];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt();
            nums[i] = r;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        quickSortViaPartition(nums, 0, nums.length - 1);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
    }

    public static void quickSortViaPartition(int[] arr, int low, int high) {
        /**
         * 因为用的是递归，这里不能用while，而应用if
         */
        if (low < high) {
            int pivot = partition(arr, low, high);
            /**
             * 为什么不需要对pivot+-1进行判断，因为只有当low<high的时候才会执行
             */
            quickSortViaPartition(arr, low, pivot - 1);
            quickSortViaPartition(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        /**
         * 取出的是low，就要从high开始
         */
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
//        System.out.println(Arrays.toString(arr));
        return low;
    }
}
