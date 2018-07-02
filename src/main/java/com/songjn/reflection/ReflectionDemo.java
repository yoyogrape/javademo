package com.songjn.reflection;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

/**
 * @author songjn
 * @create 2018-06-18 09:40
 * @desc java反射
 **/
public class ReflectionDemo {

    public static void main(String[] args) {
    }

    /*
     * 反射调用私有方法
     * */
    @Test
    public void getMyselfAllMethods() {
        Class<Dog> dogClass = Dog.class;
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //查看自己所有的方法（公有+私有，没有父类）
//            System.out.println(declaredMethod.getName());
            if (declaredMethod.getName().equals("say")) {
                //设置私有方法可以被访问（去除访问修饰符的检查）
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(
                            new Dog(1, "花花", 3));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 获取父类和自己所有的公有方法
     * */
    @Test
    public void getDogAllMethods() {
        Class<Dog> dogClass = Dog.class;
        //获取包名
        Package aPackage = dogClass.getPackage();
        //getMethods：获取类中所有方法（包括父类中的方法，但是不包括私有方法）
        Method[] methods = dogClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);//打印所有方法
            //调用toString方法
            if (method.getName().equals("toString")) {
                try {
                    Object huaDog = method.invoke(
                            new Dog(1, "花花", 3));
                    System.out.println(huaDog);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 通过class对象实例化类对象，调用所有属性（私有和公有）
     * */
    @Test
    public void getPropertys() {
        Class<Dog> dogClass = Dog.class;
        Field[] declaredFields = dogClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            int modifiers = declaredField.getModifiers();
            System.out.println(Modifier.toString(modifiers)
                    + " " + declaredField.getName());
        }
    }

    /*
     * 通过class对象实例化类对象，调用有参构造器
     * */
    @Test
    public void getParamConstructor() {
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName() + "\n"
                    + constructor.getParameterCount());
        }
        try {
            Constructor<Dog> constructor = dogClass.getConstructor(int.class
                    , String.class, int.class);
            Dog dog = constructor.newInstance(1, "小白", 3);
            System.out.println("狗的名字叫" + dog.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * 通过class对象实例化类对象，调用无参构造器
     * */
    public void getNoParamConstructor() {
        Class<Dog> dogClass = Dog.class;
        try {
            Dog dog = dogClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("ss" + dogClass.toString());
    }

    /*
     * 三种通过反射获取类对象的方法。
     * */
    @Test
    public void getDogClass() {
        //1.通过对象的getClass（）方法
        Dog dog = new Dog();
        Class<? extends Dog> dogClass1 = dog.getClass();

        //2.通过  类。class
        Class<Dog> dogClass2 = Dog.class;

        //3.通过Class.forName()
        try {
            Class dogClass3 = Class.forName("com.songjn.reflection.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
