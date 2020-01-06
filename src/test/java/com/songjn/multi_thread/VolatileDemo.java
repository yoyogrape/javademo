package com.songjn.multi_thread;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    /*volatile*/ boolean running = true;   // 对比有无volatile的情况下，整个程序运行结果的区别
    void m() {
        System.out.println(" m start ");
        while (running) { // 直到主线程将running设置为false，T线程才会退出
            // 在while中加入一些语句，可见性问题可能就会消失，这是因为加入语句后，CPU可能就会出现空闲，然后就会同步主内存中的内容到工作内存
            // 所以，可见性问题可能会消失
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("循环呀。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" m end ");
    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo::m, "t1").start();
        try {
            System.out.println("111");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("222");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("333");
        volatileDemo.running = false;
    }
}