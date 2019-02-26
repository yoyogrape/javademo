package com.songjn.java8.optional;

import com.songjn.java8.lambda.Employee;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.multi.MultiLabelUI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/*
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 25, 999.99),
            new Employee("李四", 22, 888.99),
            new Employee("王五", 23, 979.99),
            new Employee("赵六", 26, 955.99),
            new Employee("田七", 29, 779.99)
    );


    //习题
    @Test
    public void test6() {
        Employee employee = new Employee("zhangs1", 29, 779.99);
        //原来写法
//        if(employee!=null){
//            String name = employee.getName();
//            if(name!=null){
//                String s = name.toLowerCase();
//            }
//        }

        //Optional写法
        //用法一：获取不为null的对象
        Employee employee1 = Optional.ofNullable(employee).orElse(new Employee());//获取默认值为new对象的employee1

        //用法二：如果有值执行something
        Optional.ofNullable(employee).ifPresent(e ->{
            //TODO
            e.getName();
        });

        //用法三：
        Employee emp = new Employee(null, 29, 779.99);
        Optional<Integer> integer = Optional.ofNullable(emp)
                .map(e -> e.getName())
                .map(n -> n.length());
        System.out.println(integer.get());


    }



    //map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
    @Test
    public void test4() {
        Optional<Employee> employee = Optional.ofNullable(new Employee("赵六", 26, 955.99));
        Optional<String> name = employee.map(e -> e.getName());

        System.out.println(name.get());
    }

    //Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
    @Test
    public void test3() {
        Optional<Employee> employee = Optional.ofNullable(new Employee());
       // System.out.println(employee.get());//Employee{, name='null', age=null, salary=null}

        Optional<Employee> op = Optional.ofNullable(null);
        System.out.println(op.get());
        if (op.isPresent()) {//有值
        //    System.out.println(op.get());
        }
        //Employee emp = op.orElse(new Employee("张三", 25, 999.99));//设置默认值，如果没有值就拿默认值
        Employee emp = op.orElseGet(Employee::new);//函数式接口，灵活
     //   System.out.println(emp);

        //System.out.println(op.get());//NoSuchElementException

    }

    //Optional.empty() : 创建一个空的 Optional 实例
    @Test
    public void test2() {
        Optional<Employee> employee = Optional.empty();
        System.out.println(employee.get());//NoSuchElementException
    }

    //Optional.of(T t) : 创建一个 Optional 实例
    @Test
    public void test1() {
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println(employee);//Optional[Employee{, name='null', age=null, salary=null}]
        System.out.println("---------------");


        Optional<String> str = Optional.of(null);//快速锁定NPE
        System.out.println(str);//NPE
    }

}
