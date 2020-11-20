package com;

import com.thread.ThreadClass1;
import com.thread.ThreadClass2;
import com.thread.ThreadClass3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1. 练习线程的几种创建方式
 * 2. 企迈影院扩建后，新增加1个窗口，要求顺序售卖，请打印出（窗口名称）
 * 3. 设计3个线程，其中2个线程对数字index进行 +1 操作，另外一个线程进行 -1 操作，要求线程安全
 * 4. 写两个线程，一个线程打印1~52，另一个线程打印A~Z，打印顺序是12A34B...5152Z；
 * 3.写两个线程，两个线程交替打印1-100的数组
 */
public class Main {

    public static void main(String[] args) {
        // 继承实现线程
//	    Thread thread = new ThreadClass1();
//	    thread.start();
//
//	    // 实现接口
//        Runnable runnable = new ThreadClass2();
//        Thread thread1 = new Thread(runnable);
//        thread1.start();
//
//        try {
//            ThreadClass3 threadClass3 = new ThreadClass3();
//            FutureTask<Object> futureTask = new FutureTask<>(threadClass3);
//            Thread thread2 = new Thread(futureTask);
//            thread2.start();
//            Object result = futureTask.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        ticket();

//        sync();

//        print();

        printArr();
    }


    public static void ticket() {
        TicketClass ticketClass = new TicketClass();
        Thread thread1 = new Thread(ticketClass, "窗口1");
        Thread thread2 = new Thread(ticketClass, "窗口2");
        Thread thread3 = new Thread(ticketClass, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }


    public static void sync() {
        Sync add1 = new Sync("add");
        Sync add2 = new Sync("add");
        Sync sub = new Sync();

        Thread thread1 = new Thread(add1, "add1");
        Thread thread2 = new Thread(add2, "add2");
        Thread thread3 = new Thread(sub, "sub");

        thread1.start();
        thread2.start();
        thread3.start();
    }


    public static void print() {
        Print p = new Print();

        new Thread(()-> p.printNum(), "打印数字").start();
        new Thread(()-> p.printChar(), "打印字母").start();

    }


    public static void printArr() {
        PrintArray printArray = new PrintArray();

        new Thread(()-> printArray.echoEven(), "打印偶数").start();
        new Thread(()-> printArray.echoOdd(), "打印奇数").start();
    }

}
