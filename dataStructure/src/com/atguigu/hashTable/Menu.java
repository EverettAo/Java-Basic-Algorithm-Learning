package com.atguigu.hashTable;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void print() {
        System.out.println();
        System.out.println("1. 添加节点");
        System.out.println("2. 打印hash表");
        System.out.println("3. 退出");
        System.out.println("4. 根据id查找");
    }

    public static int getChoice() {
        return scanner.nextInt();
    }
}
