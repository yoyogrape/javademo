package com.songjn.sortarrpro;

/**
 * @author songjn
 * @create 2018-06-01 23:28
 * @desc 递归算法
 *
 * 注意：
 * 1.递归必须必有出口。
 * 2.消耗内存大。容易发生内存溢出。
 *
 **/
public class Recursive {
    public static void main(String[] args) {
        System.out.println(digui(5));
        System.out.println("-----------------");
        System.out.println(jiecheng(5));
    }

    public static int jiecheng(int num) {
        int result = num;
        int i = num - 1;
        do {
            result = result * i;
            i--;
        } while (i > 1);
        return result;
    }

    public static int digui(int num) {
        if (num == 1) {
            return 1;
        }
        return num * digui(num - 1);
    }
}
