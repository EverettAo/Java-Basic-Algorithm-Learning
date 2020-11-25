package com.atguigu.hashTable;

import com.atguigu.hashTable.hashTable;
import javafx.scene.control.MenuItem;

import java.util.Scanner;

public class testHashTable {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入hash表的长度(integer): ");
        hashTable ht = new hashTable(scanner.nextInt());
        int c;
        boolean flag = true;
        while (flag) {
            Menu.print();
            c = Menu.getChoice();
            switch (c) {
                case 1:
                    System.out.print("请输入id(整数): ");
                    int id = scanner.nextInt();
                    System.out.print("请输入name: ");
                    String name = scanner.next();
                    ht.insertEle(new Node(id, name));
                    break;
                case 2:
                    ht.printHashTable();
                    break;
                case 3:
                    flag = false;
                    break;
                case 4:
                    System.out.print("请输入id(integer): ");
                    Node node = ht.findNodeById(scanner.nextInt());
                    System.out.println(node);
                default:
                    break;
            }
        }
    }
}
