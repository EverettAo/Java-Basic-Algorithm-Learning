package com.atguigu.queue;

/**
 * @author Everett
 */
public class CircleQueue {
    /**
     * front指向队列首元素的位置
     * rear指向队列尾后面一个元素的位置
     * 判满条件为：(rear + 1) % maxSize = front
     * 判空条件为：rear = front
     * 队列中的实际元素个数：(rear + maxSize - front)%maxSize
     */
    private int front;
    private int rear;
    private int maxsize;
    private int[] arr;

    public CircleQueue(int maxsize) {
        this.maxsize = maxsize + 1;
        arr = new int[this.maxsize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.arr[front];
    }

    public int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.arr[front++];
    }

    public void addElement(int ele) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        this.arr[rear++] = ele;
    }

    public int getCapacity() {
        return maxsize - 1;
    }

    public int size() {
        return (rear + maxsize - front) % maxsize;
    }

    public void showAllElement() {
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxsize, arr[i % maxsize]);
        }
    }
}
