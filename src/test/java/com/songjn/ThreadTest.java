package com.songjn;

import java.util.concurrent.*;

/**
 * @auther songjn1
 * @create 2018-12-18
 * @desc
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        //第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executor.submit(futureTask);
        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/

        Thread.sleep(1000);

        System.out.println("主线程在执行任务");

        System.out.println("task运行结果" + futureTask.get());

        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println(i);
        }
        return sum;
    }
}
