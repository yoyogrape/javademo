package com.songjn.gof;

/**
 * @author songjn
 * @create 2018-06-03 20:36
 * @desc 代理模式
 * 解释：为其他对象提供一种代理以控制对这个对象的访问，
 * “真实对象”的代表，在访问对象时引入一定程度的间接性，
 * 因为这种间接性可以附加多种用途。
 * <p>
 * 代理可以对买电脑这个动作进行控制和添加一些额外的东西。
 **/
public class Proxy {
    public static void main(String[] args) {
        MacProxy macProxy = new MacProxy();
        macProxy.buyMac();
        macProxy.BuyMacTime();
    }
}

interface Subject {
    void buyMac();
}

class RealSubject implements Subject {
    @Override
    public void buyMac() {
        System.out.println("RealSubject买一台Mac，1000元。");
    }
}

//代理
class MacProxy implements Subject {
    //引用并创建真实对象实例，即”我“
    RealSubject realSubject = new RealSubject();

    @Override
    public void buyMac() {
        //调用真实对象的方法，进行代理购买Mac
        realSubject.buyMac();
        //代理对象额外做的操作
        this.WrapMac();
    }

    public void WrapMac() {
        System.out.println("MacProxy用盒子包装好Mac，打包费200，共计1200元。");
    }

    //可以对买mac这个动作进行处理和额外的操作
    public void BuyMacTime() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        this.buyMac();
        long end = System.currentTimeMillis();
        System.out.println("买Mac用时：" + (end - start));
    }
}
