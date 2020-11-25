package com.atguigu.mstack.StackCaculator;

public class CharStack {
    int size;
    Node head;

    public CharStack() {
        this.head = new Node();
        this.size = 0;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(char ele) {
        Node node = new Node(ele);
        node.next = head.next;
        head.next = node;
        this.size++;
    }

    public Character pop() {
        if (this.isEmpty()) {
            System.out.println("栈已空，出栈失败");
            return null;
        }
        char res = head.next.cal;
        head.next = head.next.next;
        this.size--;
        return res;
    }
}
