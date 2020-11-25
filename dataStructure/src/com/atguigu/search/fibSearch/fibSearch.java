package com.atguigu.search.fibSearch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class fibSearch {
    public static void main(String[] args) {
        int[] arr = new int[90000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date();
        String ss = format.format(start);
        System.out.println(ss);
//        System.out.println(goldSplitSearch(arr, 0, arr.length - 1, 89999));
        System.out.println(fibSearch(arr, 89999));
        Date end = new Date();
        String se = format.format(end);
        System.out.println(se);
//        int[] arr = {1, 8, 10, 89, 1000, 1234};
//        System.out.println(fibSearch(arr, 1234));
    }

    /**
     * 得到斐波拉契数列
     * 这里求斐波拉契数列搞得有点复杂，主要是其长度不好确定，如果在查找算法中也直接用ArrayList，就会比较简单
     *
     * @param max：fibs中的最大值
     * @难点： 如何确定fibnacci数列中的最大值？最大值应该刚好比待查找数组的长度大或相等
     */
    public static int[] fib(int max) {
        ArrayList fibs = new ArrayList();
        fibs.add(1);
        fibs.add(1);
        if (max == 1 || max == 2) {
            return new int[]{1, 1};
        } else {
            /**
             * i：第几个数
             */
            for (int i = 2; (int) fibs.get(i - 1) < max; i++) {
                fibs.add((int) fibs.get(i - 1) + (int) fibs.get(i - 2));
            }
            int[] arr = new int[fibs.size()];
            for (int i = 0; i < fibs.size(); i++) {
                arr[i] = (int) fibs.get(i);
            }
            return arr;
        }
    }


    public static int fibSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        /**
         * 斐波那契分割数值对应的下标，即斐波拉契数列中的第几个数
         */
        int k = 0;
        int mid = 0;
        int[] fibs = fib(arr.length);
        /**
         * 只有当high<fibs[k]-1时才表示找到了这个下标
         * 因为在求f数列的时候对其长度进行了判断，所以不需要下面找k的过程
         */
//        while (high > fibs[k] - 1) {
//            k++;
//        }
        /**
         * 下面这行代替上面的while过程
         */
        k = fibs.length-1;
        /**
         * 因为fibs[k]可能大于arr的长度，所以需要使用Arrays类构造一个新的数组并指向temp
         * 不足的部分会使用0填充，但是实际上应该用最后一个元素进行填充
         */
        int[] temp = Arrays.copyOf(arr, fibs[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        /**
         * 使用while循环来进行查找，注意，这里一定要有等于
         */
        while (low <= high) {
            mid = low + fibs[k - 1] - 1;
            if (temp[mid] == key) {
                /**
                 * 需要确定返回的是哪个下标：小一点的
                 */
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            } else if (temp[mid] < key) {
                low = mid + 1;
                /**
                 * 说明：为什么是k-1？
                 * 全部元素=前面的元素+后面的元素
                 * fibs[k] = fibs[k-1] + fibs[k-2]
                 * 因为后面有fibs[k-2]个元素，所以可以继续拆分，fibs[k-2] = fibs[k-3] + fibs[k-4]
                 * 即在fibs[k-2]前面查找，所以，k -= 2
                 * 即，因下次循环mid = fibs[k-1-2]-1
                 */
                k -= 2;
            } else {
                high = mid - 1;
                /**
                 * 说明：
                 * 全部元素=前面的元素+后面的元素
                 * fibs[k] = fibs[k-1] + fibs[k-2]
                 * 因为前面有fibs[k-1]个元素，所以可以继续拆分：fibs[k-1] = fibs[k-2] + fibs[k-3]
                 * 即在fibs[k-1]前面查找，即下次循环的时候，mid=fibs[k-1-1] - 1
                 */
                k--;
            }
        }
        return -1;
    }

    public static int goldSplitSearch(int[] arr, int left, int right, int k) {
        int mid = left + (int) (0.618 * (right - left));
        if (left > right) {
            return -1;
        }
        if (arr[mid] > k) {
            return goldSplitSearch(arr, left, mid - 1, k);
        } else if (arr[mid] < k) {
            return goldSplitSearch(arr, mid + 1, right, k);
        } else {
            return mid;
        }
    }
}
