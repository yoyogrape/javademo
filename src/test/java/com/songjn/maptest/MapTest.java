package com.songjn.maptest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther songjn1
 * @create 2018-12-19
 * @desc
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Object, Object> map = new ConcurrentHashMap<>();

        map.put("s","ss");
        map.put("s","ww");
        System.out.println("s");

    }
}
