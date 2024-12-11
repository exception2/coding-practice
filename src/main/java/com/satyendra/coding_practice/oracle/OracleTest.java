package com.satyendra.coding_practice.oracle;

import java.util.*;

public class OracleTest {
    public static void main(String[] args) throws Exception {
        // System.out.println("enter");
        Map<Integer, Integer> map = Map.of(1, 11, 2, 22, 3 ,33);
        // arraylist add() , remove(), lastRemove()

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(11);
        myArrayList.add(12);
        myArrayList.remove(Integer.valueOf(11));
        System.out.println(myArrayList.getLastRemoved());
        System.out.println(myArrayList);

    }
}

class MyArrayList<T> extends ArrayList {
    T lastElement = null;
    public MyArrayList() {
    }

    @Override
    public T remove(int index) {
        lastElement = (T)super.remove(index);
        return lastElement;
    }
    public T getLastRemoved() {
        return lastElement;
    }

}