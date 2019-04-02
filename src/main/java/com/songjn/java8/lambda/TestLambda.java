package com.songjn.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;

/**
 * @auther songjn1
 * @create 2019-02-24
 * @desc lambda示例
 */
public class TestLambda {


    @Test
    public void test() {
        //按照年龄排序
        employees.stream()
                .sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
                .forEach(System.out::println);
        System.out.println("---------------");

        //按照年龄排序,年龄相同按照名字排序
        employees.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge()==e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return Integer.compare(e1.getAge(),e2.getAge());
                    }
                })
                .forEach(System.out::println);
        System.out.println("---------------");

        //将年龄取出来然后进行排序
        employees.stream()
                .map(e->e.getAge())
                .sorted(Integer::compare)
                .forEach(System.out::println);
        System.out.println("---------------");


        //获取最大年龄
        final Optional<Employee> max = employees.stream()
                .max((x, y) -> Integer.compare(x.getAge(), y.getAge()));
        System.out.println(max.get());
        System.out.println("---------------");


        //获取张三的信息
        employees.stream()
                .filter(employee -> employee.getName().equals("张三"))
                .forEach(System.out::println);
        System.out.println("---------------");

        //获取年龄大于25的员工
        employees.stream()
                .filter(employee -> employee.getAge()>25)
                .forEach(System.out::println);
        System.out.println("---------------");


        //获取员工的名字，并自然排序
        employees.stream()
                .map(employee -> employee.getName())
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------");

        //找出工资最低的员工
        final Optional<Employee> min = employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min.get());
        System.out.println("---------------");
    }


    /**
     * 以前进行类对象的比较
     */
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
        //Set<Integer> ts = new HashSet<>();

        ts.add(1);
        ts.add(4);
        ts.add(3);
        ts.add(9);
        ts.add(0);
        ts.forEach(System.out::println);


    }

    /**
     * lambda表达式写法
     */
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 25, 999.99),
            new Employee("李四", 22, 888.99),
            new Employee("王五", 23, 979.99),
            new Employee("赵六", 26, 955.99),
            new Employee("田七", 29, 779.99)
    );

    /**
     * filterEmp过滤方法
     */

    public List<Employee> filterEmp(List<Employee> emps, MyPredicate<Employee> pre) {
        List<Employee> ls = new ArrayList<>();
        for (Employee emp : emps) {
            if (pre.predicate(emp)) {
                ls.add(emp);
            }
        }
        return ls;
    }


    ///--------------------------  优化方案一  --------------------------

    /**
     * 获取年龄大于25岁的员工
     */
    @Test
    public void test3() {
        List<Employee> employees = filterEmp(this.employees, e -> e.getAge() > 25);
        employees.forEach(System.err::println);
    }

    /**
     * 获取年龄大于工资大于800的员工
     */
    @Test
    public void test4() {
        List<Employee> employees = filterEmp(this.employees, e -> e.getSalary() > 800);
        employees.forEach(System.err::println);
    }

    ///--------------------------  优化方案二  --------------------------

    /**
     * 直接streamAPI结合lambda实现一句话过滤
     */
    @Test
    public void test5() {
        employees.stream()
                .filter(employee -> employee.getAge() > 25)
                .forEach(System.err::println);
    }

    /**
     * 直接打印全部名字
     */
    @Test
    public void test6() {
        employees.stream()
                .map(Employee::getName)
                .forEach(System.err::println);
    }

    /**
     * 直接打印前三名名字
     */
    @Test
    public void test7() {
        employees.stream()
                .map(Employee::getName)
                .limit(3)
                .sorted()
                .forEach(System.err::println);
    }

    ///--------------------------  lambda基础语法  --------------------------


    /**
     * 操作符 ： ->
     * 左侧： 参数列表
     * 右侧： 表达式执行的功能
     *
     * 需要函数式接口的支持
     * 函数式接口：接口中只有一个抽象方法的接口,可以FunctionalInterface修饰（必须为函数式接口）
     *
     * 格式一：无参数，无返回值
     *
     * 格式二：有一个参数，无返回值
     * 只有一个参数参数的括号可以省略
     *
     * 格式三：两个以上参数参数，lambda体中有多条语句，有返回值
     *
     * 格式四：若lambda体中只有一条语句，return和{}都可以不写
     *
     */


    /**
     * lambda语法格式一：无参数，无返回值 demo
     */
    @Test
    public void demo1() {
        int num = 999;//java8默认加了final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello" + num);
            }
        };
        r.run();

        //--------表达式写法--------

        Runnable r2 = () -> System.err.println("hello word" + num);
        r2.run();
    }

    /**
     * lambda语法格式二：有一个参数，无返回值 demo
     */
    @Test
    public void demo2() {
        //Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con = x -> System.out.println(x);
        con.accept("haha");
    }


    /**
     * lambda语法格式三：两个以上参数参数，lambda体中有多条语句，有返回值
     */
    @Test
    public void demo3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("比较两个数");
            return Integer.compare(x, y);
        };
        System.out.println(com.compare(3, 2));
    }

    /**
     * lambda语法格式四：若lambda体中只有一条语句，return和{}都可以不写
     */
    @Test
    public void demo4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(3, 2));
    }


    ///--------------------------  lambda应用练习 --------------------------

    /**
     * 按年龄dao序，年龄相同安照名字排序
     */
    @Test
    public void testLambda01() {
        Collections.sort(employees, (employee1, employee2) -> {
            if (employee1.getAge() == employee2.getAge()) {
                return employee1.getName().compareTo(employee2.getName());
            } else {
                return -Integer.compare(employee1.getAge(), employee2.getAge());
            }
        });
        employees.forEach(System.out::println);
    }


    ///--------------------------  java8内置的四大函数式接口  --------------------------

    /**
     * 1、Consumer<T>:消费型接口
     * void accept（T t）；
     * <p>
     * 2、Supplier<T>:供给型接口
     * T get();
     * <p>
     * 3、Function<T,R>:函数型接口
     * R apply(T t);
     * <p>
     * 4、Predicate<T>:断言型接口
     * boolean test（T t）;
     */


    // Consumer<T>:消费型接口demo:
    @Test
    public void test8() {
        //happy(100, x -> System.out.println("消费" + x + "元"));

        Consumer<Integer> consumer = x -> System.out.println("消费100元");
        consumer.accept(10);
    }


    public void happy(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    //Supplier<T>:供给型接口:获取10个随机数
    @Test
    public void test9() {
        ArrayList<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        numList.forEach(System.err::println);
    }


    public ArrayList<Integer> getNumList(Integer size, Supplier<Integer> supplier) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ls.add(supplier.get());
        }
        return ls;
    }

    //Function<T,R>:函数型接口：处理字符串
    @Test
    public void test10() {
        System.out.println("    csnidasohgo//");
        String nidasohgo____ = strProcess("    csnidasohgo//", x -> x.trim());
        System.out.println(nidasohgo____);
    }


    public String strProcess(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //Predicate<T>:断言型接口
    @Test
    public void test11() {
        List<String> ss = Arrays.asList("ss11", "dd", "de11", "ds", "ee");
        ArrayList<String> strings = filterString(ss, s -> s.length() < 3);

        strings.forEach(System.err::println);
    }

    public ArrayList<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                strings.add(s);
            }
        }
        return strings;
    }

    ///--------------------------  lambda方法引用  --------------------------

    /**
     * 方法引用：如果lamdba体中方法已经实现了，可以使用方法引用
     * <p>
     * 主要有三种格式：
     * <p>
     * 对象：：实例方法名
     * <p>
     * 类：：静态方法名
     *
     * 类：：实例方法名
     *
     * 使用注意：
     * 1）实现的方法的  【返回值和参数列表】  必须与实现类的  【方法参数和返回值】  相同。
     * 2）x是返回值，y是参数的时候
     *
     */


    //对象：：实例方法名
    //注意：实现的方法的  【返回值和参数列表】  必须与实现类的  【方法参数和返回值】  相同。
    @Test
    public void test12() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("haha111");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("haha222");
    }

    //类：：静态方法名
    //x是返回值，y是参数的时候
    @Test
    public void test13() {
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        System.out.println(com.compare(3,5));
        Comparator<Integer> com2=Integer::compare;
        System.out.println(com2.compare(3,2));
    }

    //类：：实例方法名
    @Test
    public void test14() {
        BiPredicate<String,String> bp=(x,y)->x.equals(y);
        System.out.println(bp.test("uu","uu"));
        BiPredicate<String,String> bp2=String::equals;
        System.out.println(bp2.test("su","uu"));
    }

}
