package com.atguigu.sort.quickSort;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] numsArray = new int[]{3, 1, 11, -5, 23, 0, 99, -5, 10};
        quickSort(0, numsArray.length - 1, numsArray);
        System.out.println(Arrays.toString(numsArray));
    }

    public static void quickSort(int left, int right, int[] arr) {
        if (left == right || left < 0 || right == arr.length) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = (left + right) / 2;
        int temp;
        while (left < right) {
            while (arr[left] < arr[pivot]) {
                left++;
            }
            while (arr[right] > arr[pivot]) {
                right--;
            }
            /**
             * 注意这里break的时机，不是和pivot相比，而是left与right相比
             */
            if (left >= right) {
                break;
            }
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            /**
             * 为了避免arr[left] == arr[pivot] 或 arr[right] == arr[pivot]时的死循环——一个元素被反复换过去换过来
             * 如果上面等于时照样移动，则这里不用判断
             */
            if (arr[left] == arr[pivot]) {
                right--;
            }
            if (arr[right] == arr[pivot]) {
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
        /**
         * 进行递归前必须判断,否则容易死递归,栈溢出
         */
        if (left == right) {
            left++;
            right--;
        }
        if (l < right) {
            quickSort(l, right, arr);
        }
        if (r > left) {
            quickSort(left, r, arr);
        }
    }
}
