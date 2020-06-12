package com.songjn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * @auther songjn1
 * @create 2019-03-05
 * @desc
 */
public class Hello{
    public static void main(String[] args){
//        String str="JudgmentBranch1551751467489";
//        System.out.println(str.replaceAll("\\d+",""));
//        new HashMap<>();
        System.out.println(tableSizeFor(32));
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