package com.atguigu.divideAndConquer;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 2/7/2021 11:47 AM
 */
public class DivideAndConquerTest {
    public static void main(String[] args) {
        hanoi(1, "A", "B", "C");
    }

    /**
     * 汉诺塔问题：n个盘子，ABC三座塔，盘子原来在A上，上小下大，全部移动到C上，还是上小下大
     */
    public static void hanoi(int n, String A, String B, String C) {
        if (n <= 0) {
            return;
        } else if (n == 1) {
            System.out.println(A + "->" + C);
        } else if (n >= 2) {
            hanoi(n - 1, A, C, B);
            System.out.println(A + "->" + C);
            hanoi(n - 1, B, A, C);
        }
    }
}
