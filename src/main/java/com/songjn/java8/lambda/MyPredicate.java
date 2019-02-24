package com.songjn.java8.lambda;

/**
 * @author songjn
 * @create 2019-02-24 19:35
 * @desc  断言接口
 **/
@FunctionalInterface
public interface MyPredicate<T> {
    boolean predicate(T t);
}
