package com.songjn.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author songjn
 * @create 2018-06-10 09:26
 * @desc 程序国际化
 **/
public class InternationalizationDemo {
    public static void main(String[] args) {
        //创建一个本地语言环境该，对象会根据参数来自动选择与之相关的语言环境。
        //参数：语言，地区
        Locale locale_CN = new Locale("zh", "CN");
        Locale locale_US = new Locale("en", "US");
        //获取当前系统默认的语言环境
        Locale locale_default = Locale.getDefault();
        Scanner input = new Scanner(System.in);
        //用于绑定属性文件的工具类（参数：属性文件的基本名：包名+前缀）
        ResourceBundle r = ResourceBundle.getBundle("com.songjn.internationalization.info",locale_US);
        System.out.println(r.getString("system.name"));
        System.out.println(r.getString("input.username"));
        String username = input.nextLine();
        System.out.println(r.getString("input.password"));
        String password = input.nextLine();
        if ("admin".equals(username) && "123".equals(password)) {
            System.out.println(r.getString("login.success"));

        } else {
            System.out.println(r.getString("login.error"));

        }

    }
}
