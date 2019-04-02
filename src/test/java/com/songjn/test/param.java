package com.songjn.test;

import org.junit.jupiter.api.Test;

/**
 * @auther songjn1
 * @create 2019-02-13
 * @desc 进行参数测试
 */
public class param {
    private String HH = "haha";
    private String HH2 = "haha";

    @Test
    public void main() {
        final String haha = new String("haha");
        if (HH2 == HH) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }
    }
}
