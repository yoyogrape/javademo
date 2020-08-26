package com.songjn.java8.stream;

import com.alibaba.fastjson.JSON;
import com.songjn.java8.lambda.Employee;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author songjn
 * @create 2019-02-24 23:34
 * @desc stream（流操作）
 * <p>
 * stream的三步操作：
 * 1）创建stream
 * 2）中间操作
 * 3）终止操作
 **/
public class TestStreamAPI {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 25, 999.99),
            new Employee("李四", 22, 888.99),
            new Employee("王五", 23, 979.99),
            new Employee("赵六", 26, 955.99),
            new Employee("田七", 29, 779.99)
    );
    List<String> str = Arrays.asList("aa", "bb", "cc");
    List<Integer> num = Arrays.asList(3, 2, 1);

    //=========================1.创建steam的方式=========================
    @Test
    public void creatStream1() {

        //1)通过集合提供的stream()或parallelStream()
        ArrayList<String> strings = new ArrayList<>();
        Stream<String> stream = strings.stream();
        Stream<String> stringStream = strings.parallelStream();

        //2)通过Arrays中的静态方法stream()
        String[] ss = new String[10];
        Stream<String> stream2 = Arrays.stream(ss);

        //3)通过Stream中的静态方法of()
        Stream<String> string3 = Stream.of("ss", "ee", "tt");

        //4)创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        iterate.forEach(System.err::println);

        //生成
        Stream.generate(() -> Math.random() * 100).limit(5).forEach(System.err::println);
    }

    //=========================2. 中间操作=========================

    //1)filter(Predicate<? super T> predicate)
    @Test
    public void creatStream2() {
//        employees.stream()
//                .filter(e -> e.getAge() > 25)
//                .forEach(System.out::println);

        Employee employee = employees.stream().findFirst().get();
        System.out.println(employee);
        Employee employee2 = employees.stream().findAny().get();
        System.out.println(employee2);
    }

    //2)limit(long maxSize);
    @Test
    public void creatStream3() {
        employees.stream()
                .limit(2)
                .forEach(System.out::println);

    }

    //3)skip(long n);跳过前n个
    @Test
    public void creatStream4() {
        employees.stream()
                .skip(2)
                .forEach(System.out::println);

    }

    //4)distinct();去重（对象需要重写hashcode和equals）
    @Test
    public void creatStream5() {
        employees.stream()
                .distinct()
                .forEach(System.out::println);

    }


    /**
     * 映射
     * 5)<R> Stream<R> map(Function<? super T, ? extends R> mapper);
     * map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     */
    @Test
    public void creatStream6() {
        employees.stream()
                .map(employee -> employee.getName() + employee.getAge())
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        List<String> nameList = employees.stream().map(e -> e.getName()).collect(Collectors.toList());

    }

    /**
     * 映射
     * 6)<R> Stream<R> map(Function<? super T, ? extends R> mapper);
     * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 将流中的元素添加到流中，类似addAll()
     */
    @Test
    public void creatStream7() {
        employees.stream()
                .map(employee -> employee.getName() + employee.getAge())
                .forEach(System.out::println);

    }

    //7)Stream<T> sorted()。自然排序
    @Test
    public void creatStream8() {
        str.stream()
                .sorted()
                .forEach(System.out::println);

    }

    //7)Stream<T> sorted()。自然排序
    @Test
    public void creatStream9() {
        employees.stream()
                .sorted((x, y) -> Integer.compare(x.getAge(), y.getAge()))
                .forEach(System.out::println);


        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return -Integer.compare(e1.getAge(), e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }

    //=========================3. 终止操作=========================

    //3. 终止操作

    /**
     * allMatch——检查是否匹配所有   元素
     * anyMatch——检查是否至少匹配一个元素
     * noneMatch——检查是否没有匹配的元素
     * findFirst——返回第一个元素
     * findAny——返回当前流中的任意元素
     * count——返回流中元素的总个数
     * max——返回流中最大值
     * min——返回流中最小值
     */


    @Test
    public void creatStream10() {
        final boolean 张三 = employees.stream()
                .allMatch((e) -> e.getName().equals("张三"));
        System.out.println(张三);//false
    }

    @Test
    public void creatStream11() {
        final boolean 张三 = employees.stream()
                .anyMatch((e) -> e.getName().equals("张三"));
        System.out.println(张三);//true
    }

    //找出最低工资
    @Test
    public void creatStream12() {
        final Double d = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare).get();
        System.out.println(d);
    }

    //归约
    //reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
    @Test
    public void creatStream13() {
        final Integer count = num.stream().reduce(0, (x, y) -> x + y);
        System.out.println(count);

        //计算工资的总和
        final Optional<Double> reduce = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce.get());
    }

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void creatStream14() {
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())//将名字收集到一个集合中去
                .forEach(System.out::println);

        Optional<Double> max = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        Optional<Employee> op = employees.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println(op.get());

        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println(sum);

        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avg);

        Long count = employees.stream()
                .collect(Collectors.counting());

        System.out.println(count);

        System.out.println("--------------------------------------------");

        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getMax());
    }

    //分组
    @Test
    public void test5() {
        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName));

        System.out.println(map);
    }

    //多级分组
    @Test
    public void test6() {
        Map<String, Map<String, List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60)
                        return "老年";
                    else if (e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));

        System.out.println(map);
    }

    //分区
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

        System.out.println(map);
    }

    //
    @Test
    public void test8() {
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "----", "----"));

        System.out.println(str);
    }

    @Test
    public void test9() {
        Optional<Double> sum = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));

        System.out.println(sum.get());
    }


    @Test
    public void test10() {
        employees.stream()
                .map(emp -> {
                    if ("张三".equals(emp.getName())) {
                        emp.setSalary(emp.getSalary() + 100);
                    }
                    return emp;
                }).collect(Collectors.toList());

        employees.forEach(System.out::println);

    }




}
