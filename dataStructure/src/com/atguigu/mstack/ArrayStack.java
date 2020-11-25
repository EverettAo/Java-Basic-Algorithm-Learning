package com.atguigu.mstack;

public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;
    private int size;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.size = 0;
        this.stack = new int[capacity];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int ele) {
        if (this.isFull()) {
            System.out.println("栈已满，入栈失败");
            return;
        }
        this.stack[++this.top] = ele;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("栈已空，出栈失败");
            return -1;
        }
        return this.stack[this.top--];
    }
}
