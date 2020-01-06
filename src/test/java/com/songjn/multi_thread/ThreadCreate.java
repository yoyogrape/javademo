package com.songjn.multi_thread;

public class ThreadCreate {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadTwo());
        t1.setName("第二个线程2");
        t1.start();
    }

}

class ThreadOne extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // 取得当前线程的名字
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}

class ThreadTwo implements Runnable {
    @Override
    public void run() {    // 覆写run()方法
        for (int i = 0; i < 3; i++) {
            // 取得当前线程的名字
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}
