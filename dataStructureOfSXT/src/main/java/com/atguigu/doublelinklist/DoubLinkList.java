package com.atguigu.doublelinklist;

import java.util.Scanner;

public class DoubLinkList {
    private final static Scanner scanner = new Scanner(System.in);

    public static DNode CreateNode() {
        System.out.println("请输入新节点的值（整数）：");
        int temp = scanner.nextInt();
        return new DNode(temp);
    }

    /**
     * 添加节点到开始，有表头
     *
     * @param head 表头
     * @param node 要添加的节点
     * @return 表头
     */
    public static DNode addNode2Start(DNode head, DNode node) {
        if (head.next == null) {
            node.next = null;
            node.prev = head;
            head.next = node;
        } else {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }
        return head;
    }

    /**
     * 添加节点到最后，有表头
     *
     * @param head 表头
     * @param node 要添加的节点
     * @return 表头
     */
    public static DNode addNode2End(DNode head, DNode node) {
        DNode pre = head;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = node;
        node.prev = pre;
        node.next = null;
        return head;
    }

    /**
     * 双链表的反转，无头节点
     *
     * @param head 第一个节点
     * @return 反转后的第一个节点
     */
    public static DNode reverseList(DNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DNode temp;
        DNode cur = head;
        DNode next = cur.next;
        while (next != null) {
            temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;
            cur = next;
            next = cur.next;
        }
        return cur;
    }
}
