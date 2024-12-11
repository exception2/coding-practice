package com.satyendra.coding_practice.general;

import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadThreadToPrintNaturalNumbers {

    public static void main(String[] args) {
        PrinterSolution printerSolution = new PrinterSolution();
        printerSolution.startPrinting();
    }
}

class PrinterSolution {
    private final int n = 10;
    private int val = 1;
    private int turn = 1;
    private final Object lock = new Object();

    Thread t1 = new Thread(() -> {
        while (val < n) {
            synchronized (lock) {
                while(turn != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " printed : " + val++);
                turn = 2;
                lock.notifyAll();
            }
        }
    });

    Thread t2 = new Thread(() -> {
        while (val < n) {
            synchronized (lock) {
                while(turn != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " printed : " + val++);
                turn = 3;
                lock.notifyAll();
            }
        }
    });

    Thread t3 = new Thread(() -> {
        while (val < n) {
            synchronized (lock) {
                while(turn != 3) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " printed : " + val++);
                turn = 1;
                lock.notifyAll();
            }
        }
    });

    public void startPrinting() {
        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
