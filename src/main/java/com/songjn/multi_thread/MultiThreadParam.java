package com.songjn.multi_thread;

class Data {
    public int value = 0;
}

class Work {
    public void process(Data data, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            data.value +=numbers[i] ;
        }
    }
}

public class MultiThreadParam extends Thread {
    private Work work;

    public MultiThreadParam(Work work) {
        this.work = work;
    }

    public void run() {
        java.util.Random random = new java.util.Random();
        Data data = new Data();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(2000);
        int n3 = random.nextInt(3000);
        int [] iii={n1, n2, n3};
        work.process(data, iii); // 使用回调函数
        System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+"
                + String.valueOf(n3) + "=" + data.value);
    }

    public static void main(String[] args) {
        Thread thread = new MultiThreadParam(new Work());
        thread.start();
    }
}
