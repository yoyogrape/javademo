package com.songjn.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author songjn
 * @create 2018-06-18 22:07
 * @desc 正则表达式
 **/
public class RegularExpression {
    public static void main(String[] args) {
        //创建一个匹配模式（模板）
        Pattern compile = Pattern.compile("a*b");
        Matcher matcher = compile.matcher("aaaab");
        //匹配
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
}
