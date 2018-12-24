package com.songjn.getcalssnamemethodname;

import org.junit.jupiter.api.Test;

/**
 * @auther songjn1
 * @create 2018-12-23
 * @desc    获取类名和方法名
 */
public class Say {
    @Test
    void haha() {
        //String s = this.getClass().getName().toString();
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        System.out.println(method);
    }
}
