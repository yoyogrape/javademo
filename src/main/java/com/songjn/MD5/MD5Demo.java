package com.songjn.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author songjn
 * @create 2018-06-08 23:23
 * @desc 密文存储用户密码
 **/
public class MD5Demo {
    public static void main(String[] args) {
        String password = "admin12345";
        String savePassword = "dIjjMbi2TleU2j+k6xCtXQ==";//存储的密文
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            //通过MD5计算摘要
            byte[] bytes = md.digest(password.getBytes("UTF-8"));
            System.out.println(Arrays.toString(bytes));
            String mdStr = new String(bytes);
            System.out.println(mdStr);
            //1.8以后
            //计算摘要以后用Base64（a-z,A-Z,0-9,/,*）来表示
            String stringBase64 = Base64.getEncoder().encodeToString(bytes);
            System.out.println(stringBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
