package com.atguigu.mstack.StackCaculator;

/**
 * @author Everett
 */
public class TemplateStack<T> {
    int size;
    TemplateNode<T> head;

    public TemplateStack() {
        this.head = new TemplateNode<>();
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(T ele) {
        TemplateNode<T> node = new TemplateNode<>(ele);
        node.next = head.next;
        head.next = node;
        this.size++;
    }

    public T pop() {
        if (this.isEmpty()) {
            System.out.println("栈已空，出栈失败");
            return null;
        }
        T res = this.head.next.val;
        head.next = head.next.next;
        this.size--;
        return res;
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if (head.next == null) {
            return null;
        } else {
            return head.next.val;
        }
    }

    public int priority(TemplateNode<Character> c) throws Exception {
        TemplateNode<Character> add = new TemplateNode<>('+');
        TemplateNode<Character> sub = new TemplateNode<>('-');
        TemplateNode<Character> mul = new TemplateNode<>('*');
        TemplateNode<Character> div = new TemplateNode<>('/');
        if (c.equals(add) || c.equals(sub)) {
            return -1;
        }
        if (c.equals(mul) || c.equals(div)) {
            return 1;
        }
        throw new Exception("参数类型错误");
    }
}
