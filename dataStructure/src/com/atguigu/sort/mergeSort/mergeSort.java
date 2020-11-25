package com.atguigu.sort.mergeSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class mergeSort {
    public static void main(String[] args) {
        int[] nums = new int[8];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt();
            nums[i] = r;
        }
        System.out.println(Arrays.toString(nums));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        mergeSort(nums, 0, nums.length - 1);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        /**
         * 注意temp的长度，是arr.length，当然也可以设置为high-low+1，不过那样后续稍微麻烦点
         */
        int[] temp = new int[arr.length];
        /**
         * 注意是从low开始，而非0，且high时也要赋值
         */
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low, j = mid + 1, k = low;
        for (; i <= mid && j <= high; k++) {
            if (temp[i] < temp[j]) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= high) {
            arr[k++] = temp[j++];
        }
    }
}
