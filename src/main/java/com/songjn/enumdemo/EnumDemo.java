package com.songjn.enumdemo;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

/**
 * @author songjn
 * @create 2018-06-19 21:39
 * @desc 枚举
 **/
public class EnumDemo {
    public myColor colorEnum;

    @Test
    public void getEnumColor() {
        colorEnum = myColor.BLUE;
        //枚举下标
        System.out.println(colorEnum.ordinal());
        //生成枚举中所有元素
        myColor[] values = myColor.values();
        System.out.println(Arrays.toString(values));
    }
}

// 枚举类型
enum myColor {
    RED, GREEN, BLUE;
}