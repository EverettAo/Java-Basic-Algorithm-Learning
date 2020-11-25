package com.atguigu.search.binarySearch;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11, 20, 234};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 10));
    }

    /**
     * 二分查找需要有序
     * 递归形式
     * 细节：找不到的情况
     */
    public static int binarySearch(int[] arr, int left, int right, int k) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] > k) {
            return binarySearch(arr, left, mid - 1, k);
        } else if (arr[mid] < k) {
            return binarySearch(arr, mid + 1, right, k);
        } else {
            return mid;
        }
    }
}
