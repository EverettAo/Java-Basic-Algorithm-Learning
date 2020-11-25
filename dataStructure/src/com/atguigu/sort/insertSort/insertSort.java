package com.atguigu.sort.insertSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class insertSort {
    public static void main(String[] args) {
//        int[] numsArray = new int[]{3, 1, 11, -5, 23};
//        insertSort(numsArray);
//        System.out.println(Arrays.toString(numsArray));
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt();
            nums[i] = r;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        insertSort(nums);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
    }

    public static void insertSort(int[] nunList) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < nunList.length; i++) {
            insertVal = nunList[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && nunList[insertIndex] > insertVal) {
                nunList[insertIndex + 1] = nunList[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                nunList[insertIndex + 1] = insertVal;
            }
        }
    }
}
