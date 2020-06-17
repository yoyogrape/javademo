package com.songjn.designmode.工厂模式;

public class 抽象工厂模式 {
}
interface Cpu {
    void run();

    class Cpu650 implements Cpu {
        @Override
        public void run() {
            //625 也厉害
        }
    }

    class Cpu825 implements Cpu {
        @Override
        public void run() {
            //825 处理更强劲
        }
    }
}
interface Screen {

    void size();

    class Screen5 implements Screen {

        @Override
        public void size() {
            //5寸
        }
    }

    class Screen6 implements Screen {

        @Override
        public void size() {
            //6寸
        }
    }
}
interface PhoneFactory {

    Cpu getCpu();//使用的cpu

    Screen getScreen();//使用的屏幕
}
class XiaoMiFactory implements PhoneFactory {
    @Override
    public Cpu getCpu() {
        return new Cpu.Cpu825();//高性能处理器
    }

    @Override
    public Screen getScreen() {
        return new Screen.Screen6();//6寸大屏
    }
}
class HongMiFactory implements PhoneFactory {

    @Override
    public Cpu getCpu() {
        return new Cpu.Cpu650();//高效处理器
    }

    @Override
    public Screen getScreen() {
        return new Screen.Screen5();//小屏手机
    }
}