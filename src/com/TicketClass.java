package com;

public class TicketClass implements Runnable {
    private static int ticketNum = 100;

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    if (ticketNum > 0) {
                        System.out.println(Thread.currentThread().getName() + "售卖第" + ticketNum + "张门票");
                        --ticketNum;
                        Thread.sleep(100);
                    } else {
                        System.out.println(Thread.currentThread().getName() + "门票售完!!!");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
