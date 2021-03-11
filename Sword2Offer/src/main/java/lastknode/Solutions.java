package lastknode;

/**
 * @author Everett
 * @date 2021-03-05 11:30 PM
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * @author Everett
 * @version 1.0
 * @description TODO
 * @date 3/5/2021 11:30 PM
 */
public class Solutions {
    public static void main(String[] args) {

    }

    private static ListNode solution_1(ListNode pHead, int k) {
        if (pHead == null || pHead.next == null || k <= 0) {
            return null;
        }
        int counter = 1;
        ListNode f = pHead, s = pHead;
        while (counter != k && f.next != null) {
            f = f.next;
            counter++;
        }
        if (counter != k) {
            return null;
        }
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}
