package com.songjn.designmode.SevenPrinciple;

public class 单一原则 {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }

// 交通工具类
// 方式 1
// 1. 在方式 1 的 run 方法中，违反了单一职责原则
// 2. 解决的方案非常的简单，根据交通工具运行方法不同，分解成不同类即可
    static class Vehicle {
        public void run(String vehicle) {
            System.out.println(vehicle + " 在公路上运行....");
        }
    }
}
