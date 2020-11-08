package com.atguigu.linkedlist;

public class LinkedList {
    public int no;
    public String name;
    public String nickname;
    public LinkedList next;

    public LinkedList() {
    }

    public LinkedList(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
//                ", next=" + next +
                '}';
    }
}
