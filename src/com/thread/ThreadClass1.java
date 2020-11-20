package com.thread;

public class ThreadClass1 extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread实现线程");
    }
}
