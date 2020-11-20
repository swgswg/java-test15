package com;

public class PrintArray {
    public static int i = 1;

    public synchronized void echoEven() {
        while (true) {
            if (i > 100) {
                break;
            }

            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                ++i;
                notify();
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void echoOdd() {
        while (true) {
            if (i > 100) {
                break;
            }

            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                ++i;
                notify();
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
