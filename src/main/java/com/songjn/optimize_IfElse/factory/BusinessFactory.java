package com.songjn.optimize_IfElse.factory;

/**
 * @auther songjn1
 * @create 2019-01-29
 * @desc 3.建立工厂
 */
public class BusinessFactory {
    private final static int B1=1;
    private final static int B2=2;

    public static Business getInstance(int cond) {
        if (cond == B1) {
            return new Business1();
        }

        if (cond == B2) {
            return new Business2();
        }
        return null;
    }
}
