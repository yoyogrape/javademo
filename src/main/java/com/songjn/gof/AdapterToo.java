package com.songjn.gof;

/**
 * @author songjn
 * @create 2018-06-03 22:09
 * @desc 适配器用法二
 *
 * 用抽象类空实现主接口作为转换器，然后再继承，
 * 这样不用将接口中所有的方法都进行实现。只完成自己想要的功能
 **/
public class AdapterToo {
    public static void main(String[] args) {
        Animal animal=new 麻雀();
        animal.fly();
    }
}
//进行空实现Animal
abstract class BirdClass implements Animal {
    @Override
    public void run() {
    }

    @Override
    public void fly() {
    }

    @Override
    public void sing() {

    }

    @Override
    public void cry() {

    }
}

interface Animal {
    void run();

    void fly();

    void sing();

    void cry();
}

//通过适配器BirdClass中间转换，不用将所有的方法都实现，更加简洁
class 麻雀 extends BirdClass {
    @Override
    public void fly() {
        System.out.println("麻雀飞飞飞！");
    }
}