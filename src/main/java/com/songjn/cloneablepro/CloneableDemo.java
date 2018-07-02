package com.songjn.cloneablepro;

/**
 * @author songjn
 * @create 2018-06-08 21:32
 * @desc 克隆
 * 对象实现克隆功能：
 * 1.实现Cloneable接口（标记接口）
 * 2.重写clone方法
 * 使用场景：创建细密的相同的对象，例如：坦克大战中的子弹。
 * 相比new对象的优势。不需要计算放对象占用多少内存等虚拟机内部的处理细节。
 **/
public class CloneableDemo {
    public static void main(String[] args) {
        Cat cat = new Cat(3, "花花");
        System.out.println(cat.toString());
        try {
            Object catClone = (Cat) cat.clone();
            System.out.println(catClone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Cat implements Cloneable {
    private int age;
    private String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}