package com.songjn.java8.lambda;

/**
 * @author songjn
 * @create 2019-02-24 16:12
 * @desc 员工实体对象
 **/

public class Employee {
    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public Employee() {
    }
    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
