package com.songjn.designmode.中介者模式;

import java.util.*;

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator 麦田 = new 麦田中介();
        Colleague zs = new 张三();
        Colleague ls = new 李四();
        麦田.register(zs);
        麦田.register(ls);
        zs.send();
//        System.out.println("-------------");
//        c2.send();
    }
}

//抽象中介者
abstract class Mediator {
    public abstract void register(Colleague colleague);

    public abstract void relay(Colleague cl); //转发
}

//具体中介者
class 麦田中介 extends Mediator {
    private List<Colleague> colleagues = new ArrayList<Colleague>();

    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    public void relay(Colleague cl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ob.receive();
            }
        }
    }
}

//抽象同事类
abstract class Colleague {
    protected Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}

//具体同事类
class 张三 extends Colleague {
    public void receive() {
        System.out.println("张三收到请求。");
    }

    public void send() {
        System.out.println("张三发出请求。");
        mediator.relay(this); //请中介者转发
    }
}

//具体同事类
class 李四 extends Colleague {
    public void receive() {
        System.out.println("李四收到请求。");
    }

    public void send() {
        System.out.println("李四发出请求。");
        mediator.relay(this); //请中介者转发
    }
}