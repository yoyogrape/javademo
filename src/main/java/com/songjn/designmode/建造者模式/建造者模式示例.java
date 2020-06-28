package com.songjn.designmode.建造者模式;

/**
 * 一句话：创建复杂对象的时候，我们无需关注复杂对象的创建过程，只需要new 不同的Builder去创建不同的对象
 *
 * 建造者（Builder）模式的主要角色如下。
 * 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件。
 * 抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 */
public class 建造者模式示例 {
    public static void main(String[] args) {
        Builder builder = new xuebiBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}

class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        //显示产品的特性
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}

abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}

class keleBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("充气");
        System.out.println("充气完成");
    }

    public void buildPartB() {
        product.setPartB("加糖");
        System.out.println("加糖完成");
    }

    public void buildPartC() {
        product.setPartC("加黑色素");
        System.out.println("加黑色素完成");
    }
}

class xuebiBuilder extends Builder {
    public void buildPartA() {
        product.setPartA("充气");
        System.out.println("充气完成");
    }

    public void buildPartB() {
        product.setPartB("加糖");
        System.out.println("加糖完成");
    }

    public void buildPartC() {
        System.out.println("雪碧不加黑色素");
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

