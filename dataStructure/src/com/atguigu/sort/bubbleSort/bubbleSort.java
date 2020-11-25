package com.atguigu.sort.bubbleSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class bubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要排序的数：");
        int[] nums = new int[80000];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt();
            nums[i] = r;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
        nums = bubbleSort(nums);
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
    }

    /**
     * 从小到大排序
     * 大的数冒到后面
     * <p>
     * 外层控制循环次数，内层进行相邻元素的交换，内层每循环一次，都有一个元素被冒到最前端或最末尾
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        int temp;
        boolean isExchange = false;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    isExchange = true;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (isExchange == false) {
                break;
            } else {
                isExchange = false;
            }
//            System.out.println("第" + i + "次排序结果为：" + Arrays.toString(nums));
        }
        return nums;
    }
}
