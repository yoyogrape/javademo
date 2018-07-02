package com.songjn.gof.observer;


/**
 * @author songjn
 * @create 2018-06-25 00:26
 * @desc 被观察者接口
 **/
public interface MessageSubject {
    //注册观察者
    void registerObserver(Observer observer);
    //移除观察者
    void removeObserver(Observer observer);
    //通知观察者
    void notifyObservers();
}
