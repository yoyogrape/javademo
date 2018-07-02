package com.songjn.systempro;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author songjn
 * @create 2018-06-08 22:07
 * @desc
 **/
public class SystemDemo {
    public static void main(String[] args) {

        System.out.println("正常信息");
        System.err.println("错误信息");//打印错误信息（红色）
        //打印当前毫秒数
        System.out.println(System.currentTimeMillis());
        //打印当前时间
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String now = df.format(date);
        System.out.println(now);
        //直接退出jvm
        System.exit(0);
        //在单独的线程中执行指定的字符串命令。
        //Runtime.getRuntime().exec("calc");

        //加载c、c++编写的类库
        System.loadLibrary("类库路径");
    }
}
