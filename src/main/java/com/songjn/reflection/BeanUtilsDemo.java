package com.songjn.reflection;


/**
 * @author songjn
 * @create 2018-06-18 16:11
 * @desc BeanUtils 工具类的使用
 **/
public class BeanUtilsDemo {
    public static void main(String[] args) {
        int userId=1;
        String userName="admin";
        String userPwd="123";
//        BeanUtils.setProperty(userId, "id", "1");
    }
}

class Emp{
    private int id;
    private  String name;
    private String psd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
}