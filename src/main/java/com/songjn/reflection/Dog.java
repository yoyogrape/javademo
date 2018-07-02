package com.songjn.reflection;

/**
 * @author songjn
 * @create 2018-06-18 09:40
 * @desc 反射要获取的类
 **/
public class Dog {
    public int type;
    private String name;
    private int age;

    public Dog() {
    }

    public Dog(int type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    private void say() {
        System.out.println("这是一个私有的方法。");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
