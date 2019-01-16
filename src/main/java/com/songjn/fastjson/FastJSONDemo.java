package com.songjn.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther songjn1
 * @create 2019-01-16
 * @desc alibaba的fastJSON测试
 */
public class FastJSONDemo {

    public static void main(String[] args) {
        final Student student = new Student(1L,"haha","男");

        //将java对象转换成字符串
        String studentStr = JSON.toJSONString(student);
        System.out.println(studentStr);

        //将json转换成json对象
        JSONObject json = JSON.parseObject(studentStr);
        System.out.println(json);

        //将json字符串转换成javaBean对象
        //final Student studentBean = JSON.parseObject(studentStr, Student.class);
        Student studentBean = JSON.parseObject(studentStr, new TypeReference<Student>() {});
        System.out.println("json==》javaBean：：：name="+studentBean.getName());

        //===============================================

        List<Student> studentList=new ArrayList<>();
        studentList.add(student);
        studentList.add(new Student(2L,"xixi","女"));


        //将集合转换成json
        final String studentListJson = JSON.toJSONString(studentList);
        System.out.println(studentListJson);

        //将json转成集合
        ArrayList<Student> students = JSON.parseObject(studentListJson, new TypeReference<ArrayList<Student>>() {});
        students.forEach(System.err::println);

    }
}
