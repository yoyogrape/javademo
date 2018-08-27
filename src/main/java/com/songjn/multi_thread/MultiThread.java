package com.songjn.multi_thread;

import org.junit.jupiter.api.Test;

/**
 * @author songjn@vlinksoft.com
 * @date 2018/8/24 0024
 * @desc 多线程demo
 * 实现多线程的两种方式：
 * ①继承Thread类
 * ②实现Runable接口
 *
 * 1. sleep()
 * sleep()方法属于Thread类，主要的作用是让当前线程停止执行，
 * 把cpu让给其他线程执行，但不会释放对象锁和监控的状态，
 * 到了指定时间后线程又会自动恢复运行状态
 *
 * 2.wait() notify()
 * wait()属于Object类，与sleep()的区别是当前线程会释放锁，
 * 进入等待此对象的等待锁定池。比方说，线程A调用Obj.wait(),
 * 线程A就会停止运行，而转为等待状态。至于等待多长时间?
 * 那就看其他线程是否调用Obj.notify().其优势显而易见，成为多个线程之间进行通讯的有手段！
 * 注意：它必须包含在Synchronzied语句中，无论是wait()还是notify()都需要首先获得目标的对象的一个监视器
 *
 * 3.Synchronzied
 * 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的部分,进入同步代码前要获得给定对象的锁
 * 修饰一个实例方法，进入同步代码前要获得当前实例的锁
 * 修饰一个静态方法，进入同步代码前要获得当前类的锁
 *
 * 4.join()
 * 在某些情况下，子线程需要进行大量的耗时运算，主线程可能会在子线程执行结束之前结束，
 * 但是如果主线程又需要用到子线程的结果，换句话说，就是主线程需要在子线程执行之后再结束。这就需要用到join()方法
 *
 * 5.yield()
 * 一个线程调用yield()意味着告诉虚拟机自己非常乐于助人，可以把自己的位置让给其他线程(这只是暗示，并不表绝对)。
 * 但得注意，让出cpu并不代表当前线程不执行了。当前线程让出cpu后，还会进行cpu资源的争夺，但是能不能再次分配到，就不一定了
 *
 * 6.isAlive()
 * 线程处于“新建”状态时，线程调用isAlive()方法返回false。
 * 在线程的run()方法结束之前，即没有进入死亡状态之前，线程调用isAlive()方法返回true.
 *
 * 7.interrupt()
 * 中断线程，将会设置该线程的中断状态位，即设置为true，
 * 中断的结果线程是死亡、还是等待新的任务或是继续运行至下一步，就取决于这个程序本身
 *
 * 8.setDaemon()
 * 守护线程，在Java中，只要一个线程没有执行完（一个线程在运行），则整个Java的进程不会消失，
 * 所以此时可以设置一个后台线程，这样即使java线程结束了，则后台线程依旧会继续执行。
 *
 * 9.getPriority()
 * 线程的优先级，优先级分为最低，最高，普通三个（Thread.MIN_PRIORITY，Thread.MAX_PRIORITY，Thread.NORM_PRIORITY）
 *
 * 10.还需要深入的两个知识点。interrupt()和Synchronzied在项目中的应用
 */

public class MultiThread {
    //===================多线程实现的两种方式=======start============
    @Test
    void exeOneTwo() {
        ThreadOne threadOne = new ThreadOne();
        new Thread(threadOne).start();//默认线程名称
        new Thread(new ThreadTwo(), "线程二").start();//自定义线程名称
        //控制台输出结果：
        //Thread-2运行，i = 0
        //Thread-2运行，i = 1
        //Thread-2运行，i = 2
        //线程二运行，i = 0
        //线程二运行，i = 1
        //线程二运行，i = 2
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
        //控制台打印
        //T1 开始
        //T1 等待
        //T2 开始
        //释放一个线程
        //T2 结束
        //T1 结束
    }

    //===================多线程wait() 和 notify()=======end============

    //===================多线程yield()=======start============
    class Person extends Thread {
        String name = null;

        public Person(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(this.getName() + i);
                if (i == 5) {
                    this.yield();
                }
            }
        }
    }

    @Test
    public void exePerson() throws InterruptedException {
        Person p1 = new Person("小花");
        Person p2 = new Person("小草");
        p1.start();
        p2.start();
    }

    //控制台打印
    //    小草1
    //    小草2
    //    小草3
    //    小草4
    //    小草5
    //    小花1
    //    小花2
    //    小花3
    //    小花4
    //    小花5
    //    小草6
    //    小草7
    //    小草8
    //    小草9
    //    小草10
    //    小花6
    //    小花7
    //    小花8
    //    小花9
    //    小花10
    //===================多线程yield()=======end============

    //===================多线程sleep()=======start============
    @Test
    void exeMyThread() throws InterruptedException {
        MyThread mt = new MyThread();    // 实例化Runnable子类对象
        Thread t = new Thread(mt, "我的线程");        // 实例化Thread对象
        t.start();    // 启动线程
        t.join();
        //控制台打印结果
        //我的线程运行，i = 0 .我的线程运行，i = 1.....每次间隔1秒
    }

    class MyThread implements Runnable {    // 实现Runnable接口
        public void run() {    // 覆写run()方法
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);    // 线程休眠
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName()
                        + "运行，i = " + i);    // 取得当前线程的名字
            }
        }
    }
    //===================多线程sleep()=======end============

    //===================多线程interrupt()=======start============
    class ThreadFour implements Runnable {    // 实现Runnable接口
        public void run() {    // 覆写run()方法
            System.out.println("1、进入run()方法");
            try {
                Thread.sleep(10000);    // 线程休眠10秒
                System.out.println("2、已经完成了休眠");
            } catch (InterruptedException e) {
                System.out.println("3、休眠被终止");
                //return;//返回调用出，不执行“4、run()方法正常结束”
            }
            System.out.println("4、run()方法正常结束");
        }
    }

    @Test
    void exeThreadFour() throws InterruptedException {
        ThreadFour mt = new ThreadFour();    // 实例化Runnable子类对象
        Thread t = new Thread(mt, "线程");        // 实例化Thread对象
        t.start();    // 启动线程
        try {
            System.out.println("exeThreadFour睡眠开始。");
            Thread.sleep(5000);    // 线程休眠2秒
            System.out.println("exeThreadFour睡眠结束。");
        } catch (InterruptedException e) {

        }
        //t.join();
        t.interrupt();    // 中断线程执行
        System.out.println("GAME OVER!");

        //控制台输出：
        //exeThreadFour睡眠开始。
        //1、进入run()方法
        //exeThreadFour睡眠结束。
        //GAME OVER!
        //3、休眠被终止
        //4、run()方法正常结束
    }
    //===================多线程interrupt()=======end============

    //===================守护线程setDaemon(true)=======start============
    class ThreadFive implements Runnable {    // 实现Runnable接口
        public void run() {    // 覆写run()方法
            int i = 0;
            while (true) {      //设置死循环，这样来实现线程不断运行，设置后台运行。
                System.out.println(Thread.currentThread().getName() + "在运行。" + i++);
            }
        }
    }

    @Test
    void exeThreadFive() throws InterruptedException {
        ThreadFive mt = new ThreadFive();    // 实例化Runnable子类对象
        Thread t = new Thread(mt, "线程");        // 实例化Thread对象
        t.setDaemon(true);    // 此线程在后台一直运行
        t.start();    // 启动线程
        //t.join();
        //控制台不停的输出
    }
    //===================守护线程setDaemon(true)=======end============

    //===================线程优先级getPriority()=======start============

    class ThreadSix implements Runnable {    // 实现Runnable接口
        public void run() {    // 覆写run()方法
            for (int i = 0; i < 50000; i++) {
                System.out.println(Thread.currentThread().getName()
                        + "运行，i = " + i);    // 取得当前线程的名字
            }
        }
    }
    @Test
    void exeThreadSix() throws InterruptedException {
        Thread t1 = new Thread(new ThreadSix(), "线程A");    // 实例化线程对象
        Thread t2 = new Thread(new ThreadSix(), "线程B");    // 实例化线程对象
        Thread t3 = new Thread(new ThreadSix(), "线程C");    // 实例化线程对象
        t1.setPriority(Thread.MIN_PRIORITY);    // 优先级最低
        t2.setPriority(Thread.MAX_PRIORITY);    // 优先级最高
        t3.setPriority(Thread.NORM_PRIORITY);    // 普通优先级
        t1.start();    // 启动线程
        t2.start();    // 启动线程
        t3.start();    // 启动线程
        t1.join();
        t2.join();
        t3.join();
    }
    //===================线程优先级getPriority()=======end============
}
