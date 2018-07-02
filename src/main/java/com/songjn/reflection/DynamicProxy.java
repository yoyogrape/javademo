package com.songjn.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author songjn
 * @create 2018-06-18 12:41
 * @desc 动态代理-反射实现
 **/
public class DynamicProxy {
    public static void main(String[] args) {
        CreateProxy createProxy = new CreateProxy();
//        Subject persion = new Persion();
//        Subject proxy = (Subject) createProxy.create(persion);
//        proxy.shopping();

        Hotel persion = new Persion();
        Hotel proxy = (Hotel) createProxy.create(persion);
        proxy.product();
    }
}

interface Subject {
    public void shopping();
}

interface Hotel{
    public void product();
}

class Persion implements Subject ,Hotel{
    @Override
    public void shopping() {
        System.out.println("买了比基尼！");
    }

    @Override
    public void product() {
        System.out.println("飞奔定好的酒店！");
    }
}

/*
 * 用于生成代理对象的类
 * */
class CreateProxy implements InvocationHandler {
    private Object target;//被代理的对象

    public Object create(Object target) { //用于创建代理对象的方法
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass()
           .getClassLoader(), target.getClass().getInterfaces(), this);
        return proxy;
    }

    /**
     * 代理对象要执行的方法
     *
     * @param proxy  代理类对象
     * @param method 被代理类对象的方法
     * @param args   被代理对象方法的参数
     */
    @Override
    public Object invoke(Object proxy
            , Method method, Object[] args) throws Throwable {
        System.out.println("去海外找客户用的产品。。。");
        System.out.println("跟客户确认物品。");
        method.invoke(target, args);
        System.out.println("完成本次海淘。");
        return null;
    }
}

