package com.atguigu.linkedlist;

import java.util.Scanner;

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

class CircleList {
    private static final Scanner scanner = new Scanner(System.in);

    public static Node createNode() {
        System.out.println("请输入值：");
        int val = scanner.nextInt();
        return new Node(val);
    }

    public static Node createCircleList(int length) {
        if (length <= 0) {
            System.out.println("长度不合法");
            return null;
        }
        Node first = CircleList.createNode();
        length -= 1;
        Node last = first;
        while (length > 0) {
            Node node = CircleList.createNode();
            length -= 1;
            last.next = node;
            last = last.next;
        }
        last.next = first;
        return first;
    }

    public static void printCircleList(Node head) {
        Node cur = head;
        if (head == null) {
            return;
        }
        System.out.println(cur);
        cur = cur.next;
        while (cur != head) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    public static void resetCircleListNum(Node head) {
        if (head == null) {
            return;
        }
        Node curNode = head;
        curNode.val = 1;
        int counter = 2;
        for (curNode = head.next; curNode != head; curNode = curNode.next) {
            curNode.val = counter++;
        }
    }

    /**
     * @param head 链表头
     * @param k    报到k的人出队
     * @return 最后剩余的人的编号
     */
    public static int josephu(Node head, int k) {
        if (head == null || head.next == head) {
            return head.val;
        }
        CircleList.resetCircleListNum(head);
        Node preNode = new Node();
        preNode.next = head;
        int counter = 0;
        while (preNode.next != preNode) {
            counter++;
            if (counter % k == 0) {
                preNode.next = preNode.next.next;
                counter = 0;
                continue;
            }
            preNode = preNode.next;
        }
        return preNode.val;
    }
}

/**
 * 约瑟夫问题，总共total个人，从第k个人开始报数，数到m的人出队，然后继续从1开始报数
 */
public class Josephu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total, k;
        System.out.println("请输入total、k：");
        total = scanner.nextInt();
        k = scanner.nextInt();
        if (k <= 0 || total <= 0) {
            System.out.println("输入不规范");
        }
        Node head = CircleList.createCircleList(total);
        System.out.println("当前循环链表为：");
        CircleList.printCircleList(head);
        System.out.println("最后留下的人为：");
        System.out.println(CircleList.josephu(head, k));
    }
}
