package com.songjn.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther songjn1
 * @create 2019-01-16
 * @desc
 */
public class dateTesa {
    public static void main(String[] args) {
//        Date date1 = new Date();
//        java.sql.Date date2 = new java.sql.Date(date1.getTime());
//        Timestamp date3 = new Timestamp(date1.getTime());
//        System.out.println(date1.toLocaleString()+"____"+date2.toLocaleString()+"_____"+date3);
//        System.out.println(DateFormat.getInstance().format(date1));
//        System.out.println(DateFormat.getInstance().format(date2));
//        System.out.println(DateFormat.getInstance().format(date3));

//        DateFormat ddf = DateFormat.getDateInstance();
//        DateFormat dtf = DateFormat.getTimeInstance();
//        DateFormat ddtf = DateFormat.getDateTimeInstance();
//        Date date = new Date();
//        System.out.println("日期：" + ddf.format(date));
//        System.out.println("时间：" + dtf.format(date));
//        System.out.println("日期时间：" + ddtf.format(date));
//        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
//        System.out.println("日期时间：" + sdf.format(date));

//        final String format = DateFormat.getDateTimeInstance().format(new Date());
//        final String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        final String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        String format = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println(format);


    }
}
