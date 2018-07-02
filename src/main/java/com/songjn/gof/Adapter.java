package com.songjn.gof;

/**
 * @author songjn
 * @create 2018-06-03 21:20
 * @desc 将一个雷的接口转换成客户希望的另外一个接口。
 * 使得由于原本接口不兼容而不能一起工作的那些类可以一起工作。
 * 用法一：电源插座的转换。
 **/
public class Adapter {
    public static void main(String[] args) {
        PowerTwoCase powerTow = new PowerTowImpl();
        work(powerTow);
        System.out.println("-----------------------");
        PowerThreeImpl powerThree = new PowerThreeImpl();
        AdapterPower adapterPower=new AdapterPower(powerThree);
        work(adapterPower);
    }

    public static void work(PowerTwoCase powerTwoCase) {
        System.out.println("连接中。。。");
        powerTwoCase.insert();
        System.out.println("工作结束。");
    }
}

//用法一：电源插座的转换。示例
class AdapterPower implements PowerTwoCase {
    private PowerThreeCase powerThreeCase;

    public AdapterPower(PowerThreeCase powerThreeCase) {
        this.powerThreeCase = powerThreeCase;
    }

    //在实现二接口的方法时将执行三孔的方法（精髓）
    @Override
    public void insert() {
        powerThreeCase.connect();
    }
}

//开始的时候接口是双插口的。
interface PowerTwoCase {
    void insert();
}

class PowerTowImpl implements PowerTwoCase {
    @Override
    public void insert() {
        System.out.println("双孔电源开始工作。");
    }
}

//后来来个三插口的头
interface PowerThreeCase {
    void connect();
}

class PowerThreeImpl implements PowerThreeCase {
    @Override
    public void connect() {
        System.out.println("我是三孔，三孔电源开始工作。");
    }
}


