package com.songjn.singleton;

import java.io.Serializable;

/**
 * @author songjn
 * @create 2018-06-18 19:08
 * @desc 单例模式的优化
 * 1、多线程访问的安全问题
 * 2、加上volatile关键字，保证变量的一致性
 * 3、防止反射调用私有构造器
 * 4、让单例类序列化安全
 * 5、还有被克隆的可能
 **/
public class Singleton implements Serializable{
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

//懒汉式单例模式
class SimpleSingleton {
    private static SimpleSingleton singleton = null;

    private SimpleSingleton() {
    }

    public static SimpleSingleton getSingleton() {
        if (singleton == null) {
            singleton = new SimpleSingleton();
        }
        return singleton;
    }
}