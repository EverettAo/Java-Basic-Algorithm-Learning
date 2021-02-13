package com.atguigu.linkedlist;

import com.atguigu.queue.CircleQueue;

import java.util.Scanner;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingleLinkedList linkedList = new SingleLinkedList();
        int key;
        boolean loop = true;
        while (loop) {
            System.out.println("1. 添加节点到链表头");
            System.out.println("2. 添加节点到链表尾");
            System.out.println("3. 获取第一个元素");
            System.out.println("4. 获取最后一个元素");
            System.out.println("5. 打印第一个元素");
            System.out.println("6. 打印最后一个元素");
            System.out.println("7. 从头到尾打印链表");
            System.out.println("8. 根据No增序添加节点到链表");
            System.out.println("9. 重新对链表排序");
            System.out.println("10. 根据no删除节点");
            System.out.println("11. 从尾到头打印链表");
            System.out.println("12. 递归反转链表");
            System.out.println("13. 非递归反转链表");
            System.out.println("14. 获取倒数第k个节点");
            System.out.println("15. 获取链表长度");
            System.out.println("16. 合并有序链表");
            System.out.println("20. 退出");
            key = scanner.nextInt();
            switch (key) {
                case 1:
                    linkedList.addNodeToHead(linkedList.createNode());
                    break;
                case 2:
                    linkedList.addNodeToEnd(linkedList.createNode());
                    break;
                case 3:
                    System.out.println(linkedList.getFirst());
                    break;
                case 4:
                    System.out.println(linkedList.getLast());
                    break;
                case 5:
                    System.out.println(linkedList.showFirst());
                    break;
                case 6:
                    System.out.println(linkedList.showLast());
                    break;
                case 7:
                    linkedList.printLinkedListFromStart();
                    break;
                case 8:
                    linkedList.insertAndSortByNo(linkedList.createNode());
                    break;
                case 9:
                    linkedList.resortByNoAsc();
                    break;
                case 10:
                    System.out.println("请输入要删除节点的no：");
                    linkedList.deleteNodeByNo(scanner.nextInt());
                    break;
                case 11:
                    linkedList.printLinkedListFromEnd(linkedList.head);
                    break;
                case 12:
                    LinkedList newHead = SingleLinkedList.reverseListByRec(linkedList.head.next);
                    linkedList.head.next = newHead;
                    System.out.println("反转结果为：");
                    linkedList.printLinkedListFromStart();
                    break;
                case 13:
                    LinkedList firstNode = SingleLinkedList.reverseList(linkedList.head.next);
                    linkedList.head.next = firstNode;
                    System.out.println("反转结果为：");
                    linkedList.printLinkedListFromStart();
                    break;
                case 14:
                    System.out.println("请输入k：");
                    int k = scanner.nextInt();
                    LinkedList node = linkedList.getLastKNode(k);
                    System.out.println("倒数第" + k + "个节点为：");
                    System.out.println(node);
                    break;
                case 15:
                    System.out.println("链表长度为：" + SingleLinkedList.getLength(linkedList.head));
                    break;
                case 16:

                    break;
                case 20:
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
