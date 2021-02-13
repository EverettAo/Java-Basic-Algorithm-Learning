package com.atguigu.doublelinklist;

public class DNode {
    public int val;
    public DNode prev;
    public DNode next;

    DNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "DNode{" +
                "val=" + val +
                '}';
    }
}
