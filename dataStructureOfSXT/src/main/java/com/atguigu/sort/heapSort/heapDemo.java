package com.atguigu.sort.heapSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class heapDemo {
    public static void main(String[] args) {
//        int[] heap = new int[]{-1, 1, 2, 3, 4, 5, 6};
//        heapSort.buildMaxHeap(heap);
//        heapSort.printMaxKEleInMaxHeap(heap, 3);
        int[] nums = new int[8000000];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt();
            nums[i] = r;
        }
//        System.out.println(Arrays.toString(nums));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        heapSort.printMaxKEleInMaxHeap(nums, nums.length - 1);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
//        System.out.println(Arrays.toString(nums));
    }
}
