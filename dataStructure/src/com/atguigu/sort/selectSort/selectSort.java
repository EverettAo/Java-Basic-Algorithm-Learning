package com.atguigu.sort.selectSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class selectSort {
    public static void main(String[] args) {
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt();
            nums[i] = r;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        selectSort(nums);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
    }

    public static void selectSort(int[] nums) {
        int max = 0;
        int maxIndex = 0;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            /**
             * 注意最后一个元素还是要选择
             */
            max = nums[0];
            maxIndex = 0;
            for (int j = 0; j <= nums.length - i; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != 0) {
                temp = nums[nums.length - i];
                nums[nums.length - i] = max;
                nums[maxIndex] = temp;
            }
//            System.out.println("第" + i + "次排序结果为：" + Arrays.toString(nums));
        }
    }
}
