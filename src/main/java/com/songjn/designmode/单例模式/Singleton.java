package com.songjn.designmode.单例模式;

import java.io.Serializable;

public class Singleton implements Serializable {
    private volatile static Singleton singleton = null;

    private Singleton() {
        if (singleton != null) {
            throw new RuntimeException("此类对象为单利模式，已经被实例化");
        }
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
//静态内部类单例
class SingleTon{
    private SingleTon(){}

    private static class SingleTonHoler{
        private static SingleTon INSTANCE = new SingleTon();
    }

    public static SingleTon getInstance(){
        return SingleTonHoler.INSTANCE;
    }
}