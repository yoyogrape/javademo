package com.songjn.designmode.模板方法模式;

/**
 * 一句话：用抽象类将模板封装好，子类去实现过程中的差异化
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new 辣条手抓饼();
        tm.TemplateMethod();
    }
}

//抽象类
abstract class AbstractClass {
    //模板方法
    public void TemplateMethod() {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    //具体方法
    public void SpecificMethod() {
        System.out.println("...开始做手抓饼...");
    }

    public abstract void abstractMethod1(); //抽象方法1

    public abstract void abstractMethod2(); //抽象方法2
}

//具体子类
class 豪华版手抓饼 extends AbstractClass {
    public void abstractMethod1() {
        System.out.println("放入葱花，香菜...");
    }

    public void abstractMethod2() {
        System.out.println("加鸡蛋，火腿...");
    }
}

//具体子类
class 辣条手抓饼 extends AbstractClass {
    public void abstractMethod1() {
        System.out.println("放生菜...");
    }

    public void abstractMethod2() {
        System.out.println("加辣条...");
    }
}