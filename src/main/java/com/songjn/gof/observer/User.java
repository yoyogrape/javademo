package com.songjn.gof.observer;

/**
 * @author songjn
 * @create 2018-06-25 00:50
 * @desc 具体的观察者
 **/
public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void updateMsg(String msg) {
        System.out.println(name+"收到消息"+msg);
    }
}
