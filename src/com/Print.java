package com;

public class Print {
    public int num = 1;
    public char aChar = 'A';
    private boolean flag = true;

    public synchronized void printNum() {
        while (true) {
            while (this.flag && this.num <= 52) {
                System.out.println(Thread.currentThread().getName() + ":" + this.num);
                ++this.num;
                System.out.println(Thread.currentThread().getName() + ":" + this.num);
                ++this.num;
                flag = false;
                notify();
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void printChar() {
        while (true) {
            while (!this.flag && this.aChar <= 'Z') {
                System.out.println(Thread.currentThread().getName() + ":" + this.aChar);
                this.aChar = (char)(this.aChar + 1);
                flag = true;
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
