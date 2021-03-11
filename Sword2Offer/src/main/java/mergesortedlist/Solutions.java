package mergesortedlist;
/**
 * @author Everett
 * @date 2021-03-06 12:08 AM
 */

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/6/2021 12:08 AM
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

    }

    private static ListNode solution_1(ListNode list1, ListNode list2) {
        ListNode Head = new ListNode(-1), curNode, last = Head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curNode = list1;
                list1 = list1.next;
            } else {
                curNode = list2;
                list2 = list2.next;
            }
            last.next = curNode;
            last = last.next;
        }
        if (list1 != null) {
            last.next = list1;
        } else {
            last.next = list2;
        }
        return Head.next;
    }

    private static ListNode solution_2(ListNode list1, ListNode list2) {
        ListNode Head = new ListNode(-1), curNode = Head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curNode.next = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }
        if (list1 != null) {
            curNode.next = list1;
        } else {
            curNode.next = list2;
        }
        return Head.next;
    }

    private static ListNode solution_3(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode Head;
        if (list1.val <= list2.val) {
            Head = list1;
            list1 = list1.next;
        } else {
            Head = list2;
            list2 = list2.next;
        }
        Head.next = solution_3(list1, list2);
        return Head;
    }
}
