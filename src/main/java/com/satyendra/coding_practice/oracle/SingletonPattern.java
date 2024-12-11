package com.satyendra.coding_practice.oracle;

public class SingletonPattern {

    private static volatile SingletonPattern obj;

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        if(obj == null) {
            synchronized (SingletonPattern.class) {
                if(obj == null) {
                    obj = new SingletonPattern();
                }
            }
        }
        return obj;
    }

    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String(s1);

        if(s1==s2) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

}

interface Test1 {

}

interface Test2 {

}

class Impl implements Test1, Test2 {

    class Node {

    }
}

interface FunctionalInterface {
    //boolean sort(a, b);
}
