package com.songjn.optimize_IfElse.factory;

/**
 * @auther songjn1
 * @create 2019-01-29
 * @desc  demo1:用工厂类去掉简单的if-else
 */
public class TestClass {

    public static void main(String[] args) {
        int cond=2;
        ///说明：解决如下简单问题
        /*
        if (cond == 1) {
            do business 1
        }
        ...
        if (cond == 2) {
            do business 2
        }
        */

        ///解决方案：
        //1、提炼接口Business
        //2、将每个业务做成实现类
        //3、建立工厂方法
        //4、使用展示

        //4、使用工厂类
        Business business = BusinessFactory.getInstance(cond);
        business.doBusiness();
    }

}
