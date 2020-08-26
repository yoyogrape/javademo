package com.songjn.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    @Test
    public void invokeDemo() throws Exception {

        UserController userController = new UserController();
        //获取字节码对象
        Class<? extends UserController> clazz = userController.getClass();
        //创建service对象
        UserService userService = new UserService();
        System.out.println(userService);//输出方法值
        //通过类型获取属性
        Field declaredField = clazz.getDeclaredField("userService");
        String name = declaredField.getName();
        //拼接set方法名称
        String setMethod = "set" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        //获取方法
        Method method = clazz.getMethod(setMethod, UserService.class);
        //执行方法
        method.invoke(userController, userService);

        System.out.println(userController.getUserService());
    }
}
