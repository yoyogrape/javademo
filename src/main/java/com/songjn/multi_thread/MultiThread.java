package com.songjn.multi_thread;

import org.junit.jupiter.api.Test;

/**
 * @author songjn@vlinksoft.com
 * @date 2018/8/24 0024
 * @desc 多线程demo
 * 实现多线程的两种方式：
 * ①继承Thread类
 * ②实现Runable接口
 * <p>
 * 1. sleep()
 * sleep()方法属于Thread类，主要的作用是让当前线程停止执行，
 * 把cpu让给其他线程执行，但不会释放对象锁和监控的状态，
 * 到了指定时间后线程又会自动恢复运行状态
 * <p>
 * 2.wait() notify()
 * wait()属于Object类，与sleep()的区别是当前线程会释放锁，
 * 进入等待此对象的等待锁定池。比方说，线程A调用Obj.wait(),
 * 线程A就会停止运行，而转为等待状态。至于等待多长时间?
 * 那就看其他线程是否调用Obj.notify().其优势显而易见，成为多个线程之间进行通讯的有手段！
 * 注意：它必须包含在Synchronzied语句中，无论是wait()还是notify()都需要首先获得目标的对象的一个监视器
 * <p>
 * 3.Synchronzied
 * 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的部分,进入同步代码前要获得给定对象的锁
 * 修饰一个实例方法，进入同步代码前要获得当前实例的锁
 * 修饰一个静态方法，进入同步代码前要获得当前类的锁
 * <p>
 * 4.join()
 * 在某些情况下，子线程需要进行大量的耗时运算，主线程可能会在子线程执行结束之前结束，
 * 但是如果主线程又需要用到子线程的结果，换句话说，就是主线程需要在子线程执行之后再结束。这就需要用到join()方法
 * <p>
 * 5.yield()
 * 一个线程调用yield()意味着告诉虚拟机自己非常乐于助人，可以把自己的位置让给其他线程(这只是暗示，并不表绝对)。
 * 但得注意，让出cpu并不代表当前线程不执行了。当前线程让出cpu后，还会进行cpu资源的争夺，但是能不能再次分配到，就不一定了
 * <p>
 * 6.isAlive()
 * 线程处于“新建”状态时，线程调用isAlive()方法返回false。
 * 在线程的run()方法结束之前，即没有进入死亡状态之前，线程调用isAlive()方法返回true.
 */

public class MultiThread {
    //===================多线程实现的两种方式=======start============
    @Test
    void exeOneTwo() {
        ThreadOne threadOne = new ThreadOne();
        new Thread(threadOne).start();//默认线程名称
        new Thread(new ThreadTwo(), "线程二").start();//自定义线程名称
        //控制台输出结果：
        //        Thread-2运行，i = 0
        //        Thread-2运行，i = 1
        //        Thread-2运行，i = 2
        //        线程二运行，i = 0
        //        线程二运行，i = 1
        //        线程二运行，i = 2
    }

    //继承Thread实现多线程
    class ThreadOne extends Thread {    // 实现Runnable接口
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                // 取得当前线程的名字
                System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
            }
        }
    }

    //实现Runnable接口实现多线程
    class ThreadTwo implements Runnable {    // 实现Runnable接口
        @Override
        public void run() {    // 覆写run()方法
            for (int i = 0; i < 3; i++) {
                // 取得当前线程的名字
                System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
            }
        }
    }
    //===================多线程实现的两种方式=======end============


    //===================多线程常见错误=======start============
    public static int count = 0;

    @Test
    void exeThree() throws InterruptedException {
        ThreadThree tt = new ThreadThree();
        Thread threadThree1 = new Thread(tt, "线程一");
        Thread threadThree2 = new Thread(tt, "线程二");
        //多次执行就会发现count有的时候不是200；因为两个线程使用的是两把不同的锁，没法保证同步。
        //Thread threadThree1 = new Thread(new ThreadThree(),"线程一");
        //Thread threadThree2 = new Thread(new ThreadThree(),"线程二");
        threadThree1.start();
        threadThree2.start();
        threadThree1.join();
        threadThree2.join();
        System.out.println(count);
    }

    public static class ThreadThree implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (this) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + "运行，count = " + count);
                }
            }
        }
    }
    //===================多线程常见错误=======end============

    //===================多线程wait() 和 notify()=======start============

    final static Object object = new Object();

    public static class one extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("T1 开始");
                try {
                    System.out.println("T1 等待");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 结束");
            }
        }
    }

    public static class two extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("T2 开始");
                System.out.println("释放一个线程");
                object.notify();
                System.out.println("T2 结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new one();
        Thread t2 = new two();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    //===================多线程wait() 和 notify()=======end============
}
