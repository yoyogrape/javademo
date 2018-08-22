package com.songjn.jihe;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author songjn@vlinksoft.com
 * @date 2018/8/22 0022
 * @desc
 */
public class ArrayListDemo {
    //==============================集合和数组相互转换===============================
    /**
     * 数组集合的相互转换
     */
    @Test
    void arrayTransform() {
        String[] _arrString = {"一", "三", "六", "二", "四"};
        //将数组转换成集合
        List<String> stooges = Arrays.asList(_arrString);
        Iterator<String> iterator = stooges.iterator();
        while (iterator.hasNext()) {//迭代器模式进行遍历
            System.out.println(iterator.next());
        }
        List listInt = new ArrayList();
        listInt.add(1);
        listInt.add(6);
        listInt.add(9);
        //将集合转换成数组
        Object[] _arrNew = listInt.toArray();
        for (Object o : _arrNew) {
            System.out.println(o);
        }
    }
    //==============================集合遍历===============================
    /**
     * map集合的遍历
     */
    @Test
    void mapDemo() {
        Map map = new HashMap();
        map.put("key1", "lisi1");
        map.put("key2", "lisi2");
        map.put("key3", "lisi3");
        map.put("key4", "lisi4");
        //1.利用【.keySet()】方法将键放到set集合中，先进行键的遍历，然后再根据键取值。
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            //System.out.println(map.get(next));
        }

        //2.利用【.entrySet()】方法，把(key-value)作为一个整体一对一对地存放到Set集合当中，Map.Entry表示映射关系。
        //此方法效率较高
        Iterator it_entry = map.entrySet().iterator();
        while (it_entry.hasNext()) {
            Map.Entry e = (Map.Entry) it_entry.next();
            //System.out.println("键" + e.getKey() + "的值为" + e.getValue());
        }

        for (Object s : map.keySet()) {//对集合键的遍历
            System.out.println(s);
        }
        for (Object s : map.values()) {//对集合值的遍历
            System.out.println(s);
        }
        for (Object s : map.entrySet()) {//对集合对象的遍历
            System.out.println(s);
        }
    }
    //==============================集合排序===============================
    //将person对象按照年龄排序
    @Test
    void listSortPerson() {
        List persons = new ArrayList();
        persons.add(new Person("haha", 6));
        persons.add(new Person("xixi", 2));
        persons.add(new Person("gaga", 3));
        persons.add(new Person("aabb", 9));
        persons.add(new Person("eeee", 9));

        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        persons.forEach(System.out::print);
    }

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    //=============================集合过滤================================
    //集合的过滤
    @Test
    void filterUser() {
        List<User> userList = Arrays.asList(
                new User("张三", 23, 5000),
                new User("李四", 24, 6000),
                new User("王五", 25, 7000),
                new User("赵六", 26, 8000)
        );
        //------1.利用filter进行过滤------
        List filterUsers1=filterUser(userList, new UserFilter() {
            @Override
            public boolean prdicate(User user) {
                return user.getSalary() > 6000;
            }
        });
        filterUsers1.forEach(System.out::print);

        //------2.lambda表达式写法------
        List filterUsers2 = filterUser(userList, (user) -> user.getAge() > 24);
        filterUsers2.forEach(System.out::print);

        //------3.使用Stream API,这样连UserFilter接口都用不到了------
        userList.stream()
                .filter((user) -> user.getSalary() > 6000)
                .limit(2) //可以限制返回的结果个数
                .forEach(System.out::println);

        //------4.打印姓名------
        userList.stream()
                .map(User::getName)
                .forEach(System.out::println);
        //------5.取出所有User姓名的集合------
        List<String> nameList = userList.parallelStream() //并行流
                .map(User::getName)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);
    }
    /**
     * 使用策略模式
     * 1.定义策略接口
     * 2.使用匿名内部类的方式,需要不同的筛选条件,
     * 就构建不同的匿名接口
     * 3.遍历集合,按传递的策略筛选元素
     */
    List<User> filterUser(List<User> userList, UserFilter userFilter) {
        List<User> resultList = new ArrayList<>();
        for (User user : userList) {
            if (userFilter.prdicate(user)) {
                resultList.add(user);
            }
        }
        return resultList;
    }
}
//过滤数据
interface UserFilter {
    boolean prdicate(User user);
}

//被过滤的类
class User {
    private String name;
    private int age;
    private int salary;

    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}


