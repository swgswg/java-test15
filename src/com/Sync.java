package com;

public class Sync implements Runnable {
    private static int num = 0;
    private String action = null;

    public Sync(String action) {
        this.action = action;
    }

    public Sync() {

    }

    @Override
    public void run() {
        while (true) {
            if ("add".equals(this.action)) {
                add();
            } else {
                sub();
            }
            System.out.println(Thread.currentThread().getName() + ":" + num);
            if (num > 10) {
                break;
            }
        }
    }

    private static synchronized void add() {
        ++num;

    }

    private static synchronized void sub() {
        --num;
    }
}
