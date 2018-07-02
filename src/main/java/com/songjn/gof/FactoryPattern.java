package com.songjn.gof;

/**
 * @author songjn
 * @create 2018-06-03 19:36
 * @desc 工厂模式（解耦）
 * 解释：由一个工厂对阿星决定创建出哪一类产品的实例，
 * 简单工厂模式是工厂模式中最简单实用的模式。
 **/
public class FactoryPattern {
    public static void main(String[] args) {
        //直接new使用者和被使用者之间产生依赖，当被使用者改变的时候会影响使用者。
        //利用工厂模式解决依赖
        //Product phone = new phone();

        Product phone = ProductFactory.getPhone();
        phone.make();
    }
}

class ProductFactory {
    public static Product getPhone() {
        return new Phone();
    }

    public static Product getComputer() {
        return new Computer();
    }

    public static Product getProduct(String productName) {
        if ("phong".equals(productName)) {
            return new Phone();
        } else if ("computer".equals(productName)) {
            return new Computer();
        } else {
            return null;
        }
    }
}

interface Product {
    void make();
}

class Phone implements Product {
    @Override
    public void make() {
        System.out.println("生产了一部手机。");
    }
}

class Computer implements Product {
    @Override
    public void make() {
        System.out.println("生产了一台电脑。");
    }
}
