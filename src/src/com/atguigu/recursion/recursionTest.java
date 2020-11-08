package com.atguigu.recursion;

public class recursionTest {
    public static void main(String[] args) {
        System.out.println(factory(5));
    }

    public static int factory(int n){
        if(n == 1){
            return 1;
        }
        return n*factory(n-1);
    }
}
