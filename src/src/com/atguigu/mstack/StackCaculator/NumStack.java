package com.atguigu.mstack.StackCaculator;

public class NumStack {
    int size;
    Node head;

    public NumStack() {
        this.head = new Node();
        this.size = 0;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(int ele) {
        Node node = new Node(ele);
        node.next = head.next;
        head.next = node;
        this.size++;
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("栈已空，出栈失败");
            return null;
        }
        int res = head.next.val;
        head.next = head.next.next;
        this.size--;
        return res;
    }
}
