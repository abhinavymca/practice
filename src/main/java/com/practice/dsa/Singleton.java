package com.practice.dsa;

public class Singleton {
    private static Singleton INSTANCE = null;
    static Object lock = new Object();

    private Singleton() {
        System.out.println("created");
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null)
                    INSTANCE = new Singleton();
            }
        }
        return INSTANCE;

    }
}
