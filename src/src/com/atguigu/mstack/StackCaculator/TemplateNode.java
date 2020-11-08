package com.atguigu.mstack.StackCaculator;

import java.util.Objects;

public class TemplateNode<T> {
    T val;
    TemplateNode<T> next;

    public TemplateNode() {
    }

    public TemplateNode(T val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TemplateNode)) {
            return false;
        }
        TemplateNode<?> that = (TemplateNode<?>) o;
        return val == that.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "TemplateNode{" +
                "val=" + val +
                '}';
    }
}
