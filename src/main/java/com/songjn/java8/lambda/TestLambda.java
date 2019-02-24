package com.songjn.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @auther songjn1
 * @create 2019-02-24
 * @desc lambda示例
 */
public class TestLambda {
    /**
     * 以前进行类对象的比较
     */
    @Test
    public void test1() {
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts=new TreeSet<>(com);
    }

    /**
     * lambda表达式写法
     */
    @Test
    public void test2(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        TreeSet<Integer> ts=new TreeSet<>(com);
    }
}
