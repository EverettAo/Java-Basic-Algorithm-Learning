package com.atguigu.search.binarySearch;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11, 20, 234};
//        System.out.println(binarySearch(arr, 0, arr.length - 1, 10));
        System.out.println(binarySearchUnrec(arr, -1));
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

    /**
     * 非递归的二分查找
     * 细节：while时的等号
     *
     * @param arr    数组
     * @param target 目标值
     * @return
     */
    public static int binarySearchUnrec(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
