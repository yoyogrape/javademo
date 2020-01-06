package com.songjn.multi_thread.c_007;

import java.util.concurrent.TimeUnit;

/**
 * 同步方法和非同步方法是否可以同时调用？
 * 答：肯定可以
 */
public class T {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        synchronized (T.class) {
            System.out.println(Thread.currentThread().getName() + " m2 start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m2 end");
        }
    }

    public static void main(String[] args) {
        T t = new T();
        T t1 = new T();
        T t2 = new T();
        new Thread(t1::m2).start();
        new Thread(t2::m1).start();
        new Thread(t::m2).start();
    }
}
