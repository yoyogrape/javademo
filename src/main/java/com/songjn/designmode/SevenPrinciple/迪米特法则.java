package com.songjn.designmode.SevenPrinciple;
import java.util.ArrayList;
import java.util.List;
//客户端
public class 迪米特法则 {
    public static void main(String[] args) {
//创建了一个 SchoolManager 对象
//        SchoolManager schoolManager = new SchoolManager();
//输出学院的员工 id 和 学校总部的员工信息
//        schoolManager.printAllEmployee(new CollegeManager());
    }

}
//学校总部员工类
class Employee {
    private String id;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
//学院的员工类
class CollegeEmployee {
    private String id;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
//管理学院员工的管理类
class CollegeManager {
    //返回学院的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) { //这里我们增加了 10 个员工到 list
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工 id= " + i);
            list.add(emp);
        }
        return list;
    }
}
