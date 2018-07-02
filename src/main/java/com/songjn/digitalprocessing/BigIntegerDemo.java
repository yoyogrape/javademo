package com.songjn.digitalprocessing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * @author songjn
 * @create 2018-06-08 22:48
 * @desc 大数的计算
 **/
public class BigIntegerDemo {
    public static void main(String[] args) {

        //大整数的计算
        String value1="235464654562246";
        String value2="2354646678662246";
        BigInteger bigInteger1 = new BigInteger(value1);
        BigInteger bigInteger2 = new BigInteger(value2);
        //大数相加
        System.out.println(bigInteger1.add(bigInteger2));
        //大数相减
        System.out.println(bigInteger1.subtract(bigInteger2));
        //大数相乘
        System.out.println(bigInteger1.multiply(bigInteger2));
        //大数相除
        System.out.println(bigInteger1.divide(bigInteger2));

        System.out.println("=====================");
        //不丢失精度小数的计算
        String value3="23.5464654562246";
        String value4="235.4646678662246";
        BigDecimal bigDecimal3 = new BigDecimal(value3);
        BigDecimal bigDecimal4 = new BigDecimal(value4);
        System.out.println(bigDecimal3.add(bigDecimal4));
        //因为无穷。所以因为除不尽会报错。
        //System.out.println(bigDecimal3.divide(bigDecimal4));

        System.out.println("=====================");
        //格式化小数位
        double pi=3.1415926;
        System.out.println(new DecimalFormat("0.000").format(pi));//3.142
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%



    }
}
