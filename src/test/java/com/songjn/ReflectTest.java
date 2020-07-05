package com.songjn;


import com.songjn.optional.User;
import com.songjn.reflect.UserController;
import com.songjn.reflect.UserService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        //获取字节码对象
        Class<? extends UserController> clazz = userController.getClass();
        //创建service对象
        UserService userService = new UserService();
        Field declaredField = clazz.getDeclaredField("userService");
        String name = declaredField.getName();
        String setMethod = "set"+name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        Method method = clazz.getMethod(setMethod, UserService.class);
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());
    }
}
