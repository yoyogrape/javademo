package com.songjn.JSONFile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songjn
 * @create 2018-06-24 22:29
 * @desc 创建JSON数据
 **/
public class CreatJSONDemo {
    @Test
    public void creatJOSN() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person(3, "tom"));
        list.add(new Person(2, "haha"));
        list.add(new Person(5, "cat"));
        JsonArray array = new JsonArray();
        for (Person person : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("jsonId", person.getAge());
            jsonObject.addProperty("jsonName", person.getName());
            array.add(jsonObject);

            Gson gson = new Gson();
            //将json对象转换成java对象
            Person personFromJosn = gson.fromJson(jsonObject, Person.class);
            //将java对象转换成json对象
            String jsonPerson = gson.toJson(personFromJosn);
        }
        System.out.println(array.toString());
    }

    @Test
    public void toJsonAndJava() {

        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/songjn/JSONFile/person.json");
        InputStreamReader in = new InputStreamReader(is);
        TypeToken<List<Person>> personTypeToken = new TypeToken<List<Person>>() {
        };
        //将一个json数组转换成java集合
        List<Person> persons = gson.fromJson(in, personTypeToken.getType());
        persons.forEach(System.out::println);
        //将一个java集合转换成json数组
        String json = gson.toJson(persons, personTypeToken.getType());
        System.out.println(json);
    }
}
