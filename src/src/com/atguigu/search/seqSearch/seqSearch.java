package com.atguigu.search.seqSearch;

public class seqSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,11,20,234};
        System.out.println(seqSearch(arr, 9));
    }

    /**
     * 只查找一个
     */
    public static int seqSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
