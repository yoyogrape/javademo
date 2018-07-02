package com.songjn.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author songjn
 * @create 2018-06-09 21:02
 * @desc Lambda表达式
 * jdk8以后
 * 基本语法:
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 **/
public class lambdaDemo {
    //接口使用的限制条件：接口中只能有一个方法；
    public static void main(String[] args) {
        //方式一：
        IEat iEat1 = new IEatImpl();
        iEat1.eat();
        //方式二：匿名内部类
        IEat iEat2 = new IEat() {
            @Override
            public void eat() {
                System.out.println("eat banana");
            }
        };
        iEat2.eat();

        //方式三：lambda表达式，代码块中有多个代码块，需要{}
        IEat iEat3 = () -> {
            System.out.println("eat orange");
        };
        iEat3.eat();

        //方式四：lambda表达式,代码块中有一个代码块。
        IEat iEat4 = () -> System.out.println("eat pare");
        iEat4.eat();

        IRun iRun = (speed) -> System.out.println("速度：" + speed);
        iRun.run("70");

        System.out.println("========上面是lambda接口上面的使用=========");

        String[] atp = {"haha", "gaga", "jeje"};
        List<String> players = Arrays.asList(atp);

        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.println("\n========使用Lambdas排序集合=========");
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));
        System.out.println("\n=======使用Lambdas排序集合==========");
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);

    }
}

interface IEat {
    void eat();
}

class IEatImpl implements IEat {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}

interface IRun {
    void run(String speed);
}

