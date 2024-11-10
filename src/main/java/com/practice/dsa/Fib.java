package com.practice.dsa;

import java.util.ArrayList;
import java.util.List;

public class Fib {

    Object object;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int fib = fib(7);
        System.out.println("fib" + list + " " + fib);
        System.out.println(hi());
    }

    static int fib(int n) {
        System.out.println(n);
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2) + 1;
    }

    static int hi() {
        try {
            return 1;
        } finally {

        }
    }
    
    static long hi(int a){
        return 1l;
    }
}
