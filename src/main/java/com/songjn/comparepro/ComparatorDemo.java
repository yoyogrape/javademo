package com.songjn.comparepro;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author songjn
 * @create 2018-06-07 22:44
 * @desc 比较器的使用。
 **/
public class ComparatorDemo {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(7, "花花")
                , new Dog(3, "绿绿")
                , new Dog(4, "草草")
                , new Dog(5, "豆豆"),};
        Arrays.sort(dogs, new DogComparator());
        System.out.println(Arrays.toString(dogs));
    }
}

class Dog {
    private int age;
    private String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getAge() - o2.getAge();
    }
}