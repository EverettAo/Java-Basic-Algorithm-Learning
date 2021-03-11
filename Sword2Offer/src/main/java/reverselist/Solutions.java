package reverselist;
/**
 * @author Everett
 * @date 2021-03-05 11:38 PM
 */

import java.util.Stack;

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/5/2021 11:38 PM
 */

class ListNode {
    int val;
    ListNode next = null;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solutions {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1 = solution_1(node1);
        while (node1 != null) {
            System.out.println(node1);
            node1 = node1.next;
        }
    }

    /**
     * 栈
     *
     * @param head
     * @return
     */
    private static ListNode solution_1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        ListNode t;
        while (temp != null) {
            t = temp.next;
            temp.next = null;
            stack.push(temp);
            temp = t;
        }
        if (!stack.isEmpty()) {
            head = stack.pop();
        }
        temp = head;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    /**
     * 直接反转
     *
     * @param head
     * @return
     */
    private static ListNode solution_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null, oNext;
        while (head.next != null) {
            oNext = head.next;
            head.next = newHead;
            newHead = head;
            head = oNext;
        }
        head.next = newHead;
        return head;
    }
}
