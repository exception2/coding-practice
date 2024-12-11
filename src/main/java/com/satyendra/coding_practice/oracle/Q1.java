package com.satyendra.coding_practice.oracle;

public class Q1 {
    /*
    part of library
    modified - add, remove
    how can I impl of class to protect modification of collection
    abc
    abcd
    * */
    private MyCollection myCollection;

    public Q1(MyCollection myCollection) {
        this.myCollection = myCollection;
    }

    public MyCollection getMyCollection() {
        MyCollection m1 = new MyCollection() {
            @Override
            public void modify() {

            }

            @Override
            public String read() {
                return myCollection.read();
            }
        };
        return m1;
    }

    public static void main(String[] args) {

        MyCollection myCollection1 = new MyCollection() {
            @Override
            public void modify() {

            }

            @Override
            public String read() {
                return null;
            }
        };
        Q1 q1 = new Q1(myCollection1);
        MyCollection myCollection2 = q1.getMyCollection();
        myCollection2.modify();
    }
}


interface MyCollection {
    void modify();

    String read();
}