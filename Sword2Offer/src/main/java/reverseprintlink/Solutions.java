package reverseprintlink;
/**
 * @author Everett
 * @date 2021-03-03 12:23 AM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author Everett
 * @version 1.0
 * @description 从尾到头打印链表
 * @date 3/3/2021 12:23 AM
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

public class Solutions {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(Arrays.toString(solution_1(node1)));
        System.out.println(solution_2(node1));
        System.out.println(Arrays.toString(solution_3(node1)));
    }

    /**
     * 压栈法
     *
     * @param head
     */
    public static int[] solution_1(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop().val;
        }
        return res;
    }

    /**
     * 逆序为数组赋值
     *
     * @param head
     * @return
     */
    public static ArrayList<Integer> solution_2(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        Integer[] arr = new Integer[length];
        node = head;
        for (int i = 0; i < length; i++) {
            arr[length - 1 - i] = node.val;
            node = node.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(length);
        Collections.addAll(arrayList, arr);
        return arrayList;
    }

    /**
     * 递归法
     *
     * @param head
     */
    static int i = 0;
    static int[] array;

    public static int[] solution_3(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        array = new int[length];
        solution_3(head, true);
        return array;
    }

    private static void solution_3(ListNode head, boolean unused) {
        if (head.next != null) {
            solution_3(head.next, true);
        }
        array[i++] = head.val;
    }
}
