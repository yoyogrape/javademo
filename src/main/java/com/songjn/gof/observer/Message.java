package com.songjn.gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songjn
 * @create 2018-06-25 00:41
 * @desc 具体的被观察者
 **/
public class Message implements MessageSubject {
    //维护观察者列表
    private List<Observer> list = new ArrayList<>();
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();

    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.updateMsg(msg);
        }
    }
}
