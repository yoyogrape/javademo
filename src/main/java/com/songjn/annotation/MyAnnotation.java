package com.songjn.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * @author songjn
 * @create 2018-06-19 23:10
 * @desc 自定义注解
 **/
//表示该注解作用范围在运行时存在
@Documented
@Retention(RetentionPolicy.RUNTIME)
//表示注解的应用范围（类型、属性、构造 器、参数、局部变量、包、注解）
//@Target(ElementType.ANNOTATION_TYPE)
@Inherited//子类可以继承
public @interface MyAnnotation {
    //定义变量
    //没有默认值default在使用的时候必须赋值
    public String name();

    //有默认值的时候注解的时候可以不进行赋值
    public int age() default 2;

    //定义一个数组变量
    public String[] like();

    //定义一个枚举型变量
    public DogColor color();

}

//测试注解
class annotationDemo {
    @Test
    public void getAnnotation() {
        Class<Dog> dogClass = Dog.class;
        //获取类上面用的指定注解
        MyAnnotation annotation = dogClass.getAnnotation(MyAnnotation.class);
        //获取注解上面的变量值
        String name = annotation.name();
        int age = annotation.age();
        DogColor color = annotation.color();
        String[] like = annotation.like();

        try {
            Dog dog = dogClass.newInstance();
            dog.setAge(age);
            dog.setColor(color);
            dog.setName(name);
            dog.setLike(like);
            System.out.println(dog.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

//枚举类型
enum DogColor {
    BLUE, RED, BLACK;
}

//通过反射将每个值赋给Dog的属性。
@MyAnnotation(name = "bean", like = {"烤鱼", "排骨"}, color = DogColor.BLUE)
class Dog {
    private String name;
    private int age;
    private DogColor color;
    private String[] like;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DogColor getColor() {
        return color;
    }

    public void setColor(DogColor color) {
        this.color = color;
    }

    public String[] getLike() {
        return like;
    }

    public void setLike(String[] like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                ", like=" + Arrays.toString(like) +
                '}';
    }
}


