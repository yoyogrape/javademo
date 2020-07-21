package com.songjn.test;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther songjn1
 * @create 2019-03-05
 * @desc
 */
public class Hello {
    public static void main(String[] args) {
//        String str="JudgmentBranch1551751467489";
//        System.out.println(str.replaceAll("\\d+",""));
//        new HashMap<>();
//        System.out.println(tableSizeFor(32));


//        boolean flag = "9.00".compareTo("10.00") <=0 ? true : false;

        try {
            Double.valueOf("2019-03-05");
        } catch (NumberFormatException e) {
            System.out.println(111);
        }
        System.out.println();

        String str1 = "2019-03-05";
        String str2 = "2019-03-02";
        // 邮箱验证规则
        String regEx = "\\d{4}-\\d{2}-\\d{2}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern.matcher(str1);
        Matcher matcher2 = pattern.matcher(str2);
        // 字符串是否与正则表达式相匹配
        boolean flag;
        boolean rs = matcher1.matches()&&matcher2.matches();
        if (rs) {
            flag = str1.compareTo(str2) <=0 ? true : false;
        }else{
            double d1 = Double.parseDouble(str1);
            double d2 = Double.parseDouble(str2);
            if (d1>d2) {
                flag=Boolean.TRUE;
            }else{
                flag=Boolean.FALSE;
            }
        }
        System.out.println(flag);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 100000) ? 100000 : n + 1;
    }
}