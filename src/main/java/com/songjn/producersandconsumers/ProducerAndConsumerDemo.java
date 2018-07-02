package com.songjn.producersandconsumers;

/**
 * @author songjn
 * @create 2018-06-16 22:22
 * @desc 生产者和消费者
 **/
public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        Food food = new Food();
        Producter producter = new Producter(food);
        Customer customer = new Customer(food);
        Thread thread1 = new Thread(producter);
        thread1.start();
        Thread thread2 = new Thread(customer);
        thread2.start();
    }
}

/*
 * 食物 Food
 * */
class Food {
    private String name;
    private String desc;
    //true表示可以生产，false表示可以消费
    private boolean flag = true;

    public Food() {
    }

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /*
     * 生产产品
     * */
    public synchronized void set(String name, String desc) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag = false;
        this.notify();
    }

    /*
     * 消费产品
     * */
    public synchronized void get() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "->" + this.getDesc());
        flag = true;
        this.notify();//唤醒等待线程（随机的其中一个）
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

/*
 * 生产者
 * */
class Producter implements Runnable {
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                food.set("锅包肉", "酸甜可口");
            } else {
                food.set("佛跳墙", "没吃过");
            }
        }
    }
}


/*
 * 消费者
 * */
class Customer implements Runnable {
    private Food food;

    public Customer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}
