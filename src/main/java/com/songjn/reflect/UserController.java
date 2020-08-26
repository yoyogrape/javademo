package com.songjn.reflect;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
