package com.songjn.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @auther songjn1
 * @create 2018-12-18
 * @desc
 */
public class AboutDate {

    public static void main(String[] args) {
        //(1)
        java.util.Date time1 = new java.util.Date();
        //(2)
        java.sql.Date time2 = new java.sql.Date(System.currentTimeMillis());
        //(3)
        java.sql.Time time3 = new java.sql.Time(System.currentTimeMillis());
        //(4)
        java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
        System.out.println(time);
        DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss 今年第ww周  第DD天");

        System.out.println(time1);
        System.out.println("---------------");
        System.out.println(time2);
        System.out.println("---------------");
        System.out.println(time3);
        System.out.println("---------------");
        System.out.println(time);
//        System.out.println("北京时间：" + sdf.format(time1) + "\n");
//        System.out.println("北京时间：" + sdf.format(time2) + "\n");
//        System.out.println("北京时间：" + sdf.format(time3) + "\n");
//        System.out.println("北京时间：" + sdf.format(time) + "\n");
    }
}
