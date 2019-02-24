package com.songjn.java8.stream;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author songjn
 * @create 2019-02-24 23:34
 * @desc stream（流操作）
 *
 * stream的三步操作：
 * 1）创建stream
 * 2）中间操作
 * 3）终止操作
 *
 **/
public class TestStreamAPI {

    //创建steam的方式
    @Test
    public void creatStream1(){

        //1)通过集合提供的stream()或parallelStream()
        ArrayList<String> strings = new ArrayList<>();
        Stream<String> stream = strings.stream();
        Stream<String> stringStream = strings.parallelStream();

        //2)通过Arrays中的静态方法stream()
        String[] ss=new String[10];
        Stream<String> stream2 = Arrays.stream(ss);

        //3)通过Stream中的静态方法of()
        Stream<String> string3=Stream.of("ss","ee","tt");

        //4)创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        iterate.forEach(System.err::println);

        //生成
        Stream.generate(()->Math.random()*100).limit(5).forEach(System.err::println);
    }

    //2. 中间操作
	/*
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
    @Test
    public void creatStream2(){

    }

}
