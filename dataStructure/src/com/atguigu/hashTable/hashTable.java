package com.atguigu.hashTable;

class Node {
    int id;
    String name;
    Node next;

    Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class LinkedList {
    private Node head = new Node();

    /**
     * 尾插法插入
     *
     * @param node
     */
    public void add2Tail(Node node) {
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void add2Head(Node node) {
        node.next = this.head.next;
        this.head.next = node;
    }

    public void addByIdIncSort(Node node) {
        Node temp = this.head;
        while (temp.next != null && temp.next.id < node.id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            node.next = temp.next;
        }
        temp.next = node;
    }

    /**
     * 根据id搜索节点
     *
     * @param id
     * @return
     */
    public Node searchById(int id) {
        Node temp = this.head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next.id == id) {
            return temp.next;
        } else {
            return null;
        }
    }

    public Node deleteById(int id) {
        Node temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next.id == id) {
            return temp.next;
        }
        return null;
    }

    public Node modifyNodeById(int id, int new_id, String new_name) {
        Node dist = this.searchById(id);
        if (dist != null) {
            dist.id = new_id;
            dist.name = new_name;
            return dist;
        }
        return null;
    }

    public void printList() {
        Node temp = this.head.next;
        System.out.print("[");
        while (temp != null) {
            System.out.print("[id=" + temp.id + "-name=" + temp.name + "]");
            temp = temp.next;
        }
        System.out.print("]");
    }
}

public class hashTable {
    private LinkedList[] hashTbl;
    private int tableLens;

    hashTable(int tableLens) throws Exception {
        if (tableLens <= 0) {
            throw new Exception("tableLens must be a positive integer");
        }
        this.tableLens = tableLens;
        hashTbl = new LinkedList[tableLens];
        for (int i = 0; i < hashTbl.length; i++) {
            hashTbl[i] = new LinkedList();
        }
    }

    public void insertEle(Node node) {
        int mod = node.id % this.tableLens;
        hashTbl[mod].addByIdIncSort(node);
    }

    public void printHashTable() {
        for (int i = 0; i < this.hashTbl.length; i++) {
            System.out.println();
            hashTbl[i].printList();
        }
    }

    public Node findNodeById(int id) {
        int mod = id % this.tableLens;
        Node node = this.hashTbl[mod].searchById(id);
        return new Node(node.id, node.name);
    }
}