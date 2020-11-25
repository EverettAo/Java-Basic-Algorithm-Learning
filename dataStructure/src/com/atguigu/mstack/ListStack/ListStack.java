package com.atguigu.mstack.ListStack;

public class ListStack {
    Node head;

    public ListStack() {
        this.head = new Node();
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(int ele) {
        Node node = new Node(ele);
        node.next = head.next;
        head.next = node;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("栈已空，出栈失败");
            return -1;
        }
        int res = head.next.val;
        head.next = head.next.next;
        return res;
    }
}
