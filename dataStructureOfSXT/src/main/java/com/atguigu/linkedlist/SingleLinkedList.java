package com.atguigu.linkedlist;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Scanner;

/**
 * 注意：之前有考虑加end和secondEnd节点，但是由于是单链表，对end节点变动时维护时仍然要遍历，因此无意义
 */
public class SingleLinkedList {
    // 头节点，不存放具体数据，事实上，可以存储元素个数
    public LinkedList head = new LinkedList();

    public LinkedList createNode() {
        Scanner scanner = new Scanner(System.in);
        int no;
        String name;
        String nickName;
        System.out.println("请输入no：");
        no = scanner.nextInt();
        System.out.println("请输入name：");
        name = scanner.next();
        System.out.println("请输入nickname：");
        nickName = scanner.next();
        return new LinkedList(no, name, nickName);
    }

    /**
     * 头插法
     *
     * @param node
     */
    public void addNodeToHead(LinkedList node) {
        node.next = head.next;
        head.next = node;
    }

    /**
     * 尾插法
     *
     * @param node
     */
    public void addNodeToEnd(LinkedList node) {
        LinkedList secondEnd = head;
        while (secondEnd.next != null) {
            secondEnd = secondEnd.next;
        }
        secondEnd.next = node;
    }

    /**
     * 返回第一个元素并从列表中删除
     *
     * @return
     */
    public LinkedList getFirst() {
        if (head.next != null) {
            LinkedList first = head.next;
            head.next = first.next;
            return first;
        } else {
            return null;
        }
    }

    /**
     * 仅获得链表第一个节点
     *
     * @return
     */
    public LinkedList showFirst() {
        return head.next;
    }

    /**
     * 返回最后一个元素并从链表删除
     */
    public LinkedList getLast() {
        LinkedList secondEnd = new LinkedList();
        secondEnd.next = head;
        LinkedList end;
        while (secondEnd.next.next != null) {
            secondEnd = secondEnd.next;
        }
        if (secondEnd.next == head) {
            return null;
        } else {
            end = secondEnd.next;
            secondEnd.next = null;
            return end;
        }
    }

    public void insertAndSortByNo(LinkedList node) {
        LinkedList pre = head;
        while (pre.next != null && pre.next.no < node.no) {
            pre = pre.next;
        }
        node.next = pre.next;
        pre.next = node;
    }

    public void deleteNodeByNo(int no) {
        LinkedList pre = head;
        while (pre.next != null) {
            if (pre.next.no == no) {
                pre.next = pre.next.next;
                return;
            }
        }
        System.out.println("不存在no=" + no + "的节点");
    }

    public void resortByNoAsc() {
        /**
         * 1. 如果链表最多一个节点
         */
        if (head.next == null || head.next.next == null) {
            return;
        }
        /**
         * newHead：新链表(排好序的)的表头
         * precur：原始链表上操作的当前节点的前一节点
         * node：newHead的链表上操作（脱链插入）的节点
         */
        LinkedList newHead = new LinkedList();
        LinkedList precur;
        LinkedList node;
        LinkedList precurSor;
        /**
         * 注意：由于head与newHead实际上是指向同一片地址，所以对head.next进行修改实际上就是对newHead.next进行修改
         */
        while (head.next != null) {
            /**
             * head就变为排序后的链
             * curNode是实际要进行比较的节点的前一个节点
             */
            precur = head;
            /**
             * 链表上真正第一个节点脱链
             */
            node = precur.next;
            precur.next = node.next;
            node.next = null;


            precurSor = newHead;
            /**
             * 在排序后的链表上找到no比 脱链节点大的节点
             */
            while (precurSor.next != null && precurSor.next.no < node.no) {
                precurSor = precurSor.next;
            }
            node.next = precurSor.next;
            precurSor.next = node;
        }
        head = newHead;
    }

    public LinkedList getLastKNode(int k) {
        LinkedList node1 = head, node2 = head;
        int counter = k;
        while (node1 != null && counter != 0) {
            node1 = node1.next;
            counter--;
        }
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }

    // head是第一个元素，链表反转最好是将表头剃除，好操作一些

    /**
     * 递归方法反转链表
     *
     * @param head 链表实际上的第一个节点
     * @return
     */
    public static LinkedList reverseListByRec(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        // newHead即原先的表头，反转后实际是表尾
        LinkedList newHead = SingleLinkedList.reverseList(head.next);
        // 反转节点的指向，将head的后结点指向head
        head.next.next = head;
        // 表头元素反转后成威最后一个元素
        head.next = null;
        return newHead;
    }

    /**
     * 还是不考虑头节点
     *
     * @param head 链表第一个节点
     * @return
     */
    public static LinkedList reverseList(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList first = head, second = first.next;
        LinkedList third = second.next;
        first.next = null;
        while (second != null) {
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        return first;
    }

    /**
     * 头插法反转链表
     *
     * @param head 第一个节点
     * @return 反转后的链表
     */
    public static LinkedList reverseListByHeadInsert(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList newHead = new LinkedList();
        newHead.next = head;
        head = head.next;
        LinkedList temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
    }

    public static int getLength(LinkedList head) {
        int counter = 0;
        LinkedList temp = head.next;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }

    public LinkedList showLast() {
        LinkedList end = head;
        while (end.next != null) {
            end = end.next;
        }
        if (end == head) {
            return null;
        }
        return end;
    }

    public void printLinkedListFromStart() {
        LinkedList curNode = head.next;
        while (curNode != null) {
            System.out.println(curNode);
            curNode = curNode.next;
        }
    }

    public void printLinkedListFromEnd(LinkedList head) {
        if (head.next != null) {
            printLinkedListFromEnd(head.next);
        }
        if (head == this.head) {
            return;
        }
        System.out.println(head);
    }

    /**
     * 合并两个升序链表，根据no，不考虑头节点
     *
     * @param list1 链表1，升序
     * @param list2 链表2，升序
     * @return 合并后的链表
     */
    public static LinkedList mergeSortedLinkList(LinkedList list1, LinkedList list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1 == list2) {
            return list1;
        }
        LinkedList newHead = new LinkedList();
        LinkedList temp = null;
        LinkedList prelast = newHead;
        if (list1.no > list2.no) {
            temp = list1;
            list1 = list2;
            list2 = temp;
        }

        while (list1.no < list2.no) {
            temp = list1;
            list1 = list1.next;
            prelast.next = temp;
            prelast = prelast.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.no <= list2.no) {
                temp = list1;
                list1 = list1.next;
                prelast.next = temp;
                prelast = prelast.next;
            } else {
                temp = list2;
                list2 = list2.next;
                prelast.next = temp;
                prelast = prelast.next;
            }
        }
        while (list1 != null) {
            prelast.next = list1;
        }
        while (list2 != null) {
            prelast.next = list2;
        }
        return newHead.next;
    }
}
