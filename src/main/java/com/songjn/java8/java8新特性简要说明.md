# java8新特性，简要说明（尚学堂）
## 1、HashMap由hash算法+链表改为  **hash算法+链表+红黑树**
## 2、ConcurrentHashMap由锁分段机制（默认16段）改为  CAS算法（无锁算法）
## 3、JVM将方法区单独出来（原来方法区属于永久区的一部分）

## 4、lambda表达式语法：
```java
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
```

## 5、java8四大核心接口
```java
    /**
     * 1、Consumer<T>:消费型接口
     * void accept（T t）；
     *  
     * 2、Supplier<T>:供给型接口
     * T get();
     *  
     * 3、Function<T,R>:函数型接口
     * R apply(T t);
     *  
     * 4、Predicate<T>:断言型接口
     * boolean test（T t）;
     */
```


