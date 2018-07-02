package com.songjn.AOP;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author songjn
 * @create 2018-06-18 17:58
 * @desc 面向切面编程 AOP框架的简单实现
 * 需求：
 * 1、在添加方法前和添加方法之后打印日志。
 * 2、查看用户有没有权限添加
 **/
public class AOPDemo {
    public static void main(String[] args) {
        //1、读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/songjn/AOP/bean.properties");

        //2、创建bean的工厂对象
        BeanFactory beanFactory = new BeanFactory(in);

        //3、获取代理对象
        ProxyFactoryBean proxyFactoryBean
                = (ProxyFactoryBean)beanFactory.getBean("bean");

        IManager proxy = (IManager) proxyFactoryBean.getProxy();

        proxy.add("I'am a Tom");
    }
}

interface IManager {
    void add(String item);
}

/*
* 需要实现的核心业务
* */
class IManagerImpl implements IManager {
    private ArrayList<String> arrayList = new ArrayList();
    @Override
    public void add(String Item) {
        arrayList.add(Item);
        System.out.println(Item);
    }
}

/*
 * 切面接口
 * */
interface Advice {
    void beforeAdvice();
    void afterAdvice();
}

/**
 * 切面实现类
 */
class LogAdvice implements Advice {

    @Override
    public void beforeAdvice() {
        System.out.println("start time:" + System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        System.out.println("end time:" + System.currentTimeMillis());
    }
}

/**
 * 代理工厂类
 */
class ProxyFactoryBean implements InvocationHandler {
    //被代理的对象
    private Object target;//业务类对象
    private Advice advice;//切面
    //获取对象的代理
    public Object getProxy() {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        advice.beforeAdvice();
        Object obj = method.invoke(target, args);
        advice.afterAdvice();
        return obj;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}

/*
* 读取配置文件类
* */
class BeanFactory{
    Properties prop=new Properties();
    public BeanFactory(InputStream in) {
        try {
            this.prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取bean实例
     */
    public Object getBean(String name){
        String className = prop.getProperty(name);
        Object bean=null;
        try {
            //获取proxyFactoryBean的class对象
            Class<?> aClass = Class.forName(name);
            bean= aClass.newInstance();//实例化对象
            //根据配置文件实例化target和advice对象
            Object target = Class.forName(prop.getProperty(name + ".target")).newInstance();
            Object advice = Class.forName(prop.getProperty(name + ".advice")).newInstance();
            //通过内省实现对ProxyFactoryBean的属性赋值
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String properName = propertyDescriptor.getName();
                Method writeMethod = propertyDescriptor.getWriteMethod();
                if("target".equals(properName)){
                    writeMethod.invoke(bean,target);
                }else if("advice".equals(properName)){
                    writeMethod.invoke(bean,advice);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
