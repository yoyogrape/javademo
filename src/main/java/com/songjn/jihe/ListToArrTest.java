package com.songjn.jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListToArrTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("haha");
        //
//        for (String item : list) {
//            if ("1".equals(item)) {
//                list.remove(item);
//            }
//        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("1".equals(next)) {
                iterator.remove();
            }
        }
        list.forEach(System.err::println);
    }
}
