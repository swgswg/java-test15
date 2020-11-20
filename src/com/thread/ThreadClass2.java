package com.thread;

public class ThreadClass2 implements Runnable {
    @Override
    public void run() {
        System.out.println("实现接口Runnable实现线程");
    }
}
