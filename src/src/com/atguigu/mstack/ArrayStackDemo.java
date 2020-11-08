package com.atguigu.mstack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入栈的大小：");
        int capacity = scanner.nextInt();
        ArrayStack stack = new ArrayStack(capacity);
        boolean isExit = false;
        int cmd;
        while (!isExit) {
            System.out.println("1. 入栈");
            System.out.println("2. 出栈");
            System.out.println("0. 退出");
            System.out.println("请输入：");
            cmd = scanner.nextInt();
            switch (cmd) {
                case 1:
                    System.out.println("请输入要入栈的值：");
                    int ele = scanner.nextInt();
                    stack.push(ele);
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    break;
            }
        }
    }
}
