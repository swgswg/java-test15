package com.thread;

import java.util.concurrent.Callable;

public class ThreadClass3 implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println("实现Callable接口实现线程");
        return "Callable";
    }
}
