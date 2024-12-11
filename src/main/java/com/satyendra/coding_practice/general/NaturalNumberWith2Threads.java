package com.satyendra.coding_practice.general;

public class NaturalNumberWith2Threads {
    public static void main(String[] args) {
        final Object lock = new Object();
        int max_number = 10;
        EvenThread evenThread = new EvenThread(max_number, lock);
        OddThread oddThread = new OddThread(max_number, lock);
        evenThread.start();
        oddThread.start();

    }
}

class OddThread extends Thread {

    private int start;
    private final Object lock;
    private final int MAX_NUMBER;

    OddThread(int MAX_NUMBER, Object lock) {
        this.lock = lock;
        this.start = 1;
        this.MAX_NUMBER = MAX_NUMBER;
    }

    @Override
    public void run() {
        while(start <= MAX_NUMBER) {
            synchronized (lock) {
                System.out.println("Odd thread printing : " + start);
                start += 2;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class EvenThread extends Thread {

    private int start;
    private final Object lock;
    private final int MAX_NUMBER;

    EvenThread(int MAX_NUMBER, Object lock) {
        this.lock = lock;
        this.start = 0;
        this.MAX_NUMBER = MAX_NUMBER;
    }

    @Override
    public void run() {
        while(start <= MAX_NUMBER) {
            synchronized (lock) {
                System.out.println("Even thread printing : " + start);
                start += 2;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}