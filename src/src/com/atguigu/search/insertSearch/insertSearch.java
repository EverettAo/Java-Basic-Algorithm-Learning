package com.atguigu.search.insertSearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class insertSearch {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 5, 7, 9, 9, 9, 9, 9, 11, 20, 234};
        int[] arr = new int[9000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(new Date());
        System.out.println(insertSearch(arr, 0, arr.length - 1, arr.length / 2));
        System.out.println(new Date());
    }

    public static int insertSearch(int[] arr, int left, int right, int k) {
        /**
         * 后两个或必须有，否则越界
         */
        if (left > right || k > arr[right] || k < arr[0]) {
            return -1;
        }
        /**
         * 注意：当数组长度太大的时候，会造成整数的溢出
         */
        int mid = left + (right - left) * (k - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] > k) {
            return insertSearch(arr, left, mid - 1, k);
        } else if (arr[mid] < k) {
            return insertSearch(arr, mid + 1, right, k);
        } else {
            return mid;
        }
    }
}
