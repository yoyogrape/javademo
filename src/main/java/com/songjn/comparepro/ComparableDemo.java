package com.songjn.comparepro;

import java.util.Arrays;

/**
 * @author songjn
 * @create 2018-06-07 21:49
 * @desc comparable用法
 * 正常 比较int 规则大小,String 规则
 * 对象是不能比较大小的，需要实现comparable接口中compareTo（）方法。
 * 来告诉计算机，你是通过比较什么进行大小排序的。
 **/
public class ComparableDemo {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("花花", 3), new Cat("绿绿", 7), new Cat("红红", 4)};
        Arrays.sort(cats);
        System.out.println(Arrays.toString(cats));
        //Arrays.toString(cats);返回指定数组内容的字符串表示形式
    }
}

class Cat implements Comparable<Cat> {
    //实现接口的时候要添加<Cat>的泛型，不然不能重写comparaTo的方法。
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
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

    //不实现通String方法打印出来的是对象的地址.
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //实现compareTo方法
    @Override
    public int compareTo(Cat cat) {
        return this.age - cat.age;
    }
}
