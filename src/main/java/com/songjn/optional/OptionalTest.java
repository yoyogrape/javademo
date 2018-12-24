package com.songjn.optional;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @auther songjn1
 * @date 2018/12/4
 * @desc jdk8的Optional类的使用
 */

public class OptionalTest {

    public static void main(String[] args) {
        //JDK8OldPressNull();
        //prameIsNull();
        //ifPresentSkill();

        User user = new User();
        //Optional<User> opt = Optional.empty();//创建一个空的User对象。
        //Optional<User> opt = Optional.of(null);//确定对象部位null的时候用of，如果对象为null会有NPE
        Optional<User> opt = Optional.of(user);
        //Optional<User> opt = Optional.ofNullable(null);//当对象可能为空的时候用ofNullable不会出现NPE异常
        //User user= opt.orElseGet(() -> new User());
        boolean present = opt.isPresent();//判断对象是不是为空
        System.out.println(present);

    }

    @Test
    void ifPresentSkill() {
        List<String> aa = new ArrayList();
        aa.add("aaa");
        aa.add("abbb");
        aa.add("accc");
        aa.add("ddd");
        System.out.println("原始值：" + aa);


        Optional<String> largest = aa.stream().max(String::compareToIgnoreCase);

        List<String> bb = new ArrayList();
        largest.ifPresent(bb::add);

        System.out.println("ifPresent 的用法：" + bb);


        Optional<Boolean> added = largest.map(bb::add);
        System.out.println("会有返回值处理:" + added.get());
    }

    private static void prameIsNull() {
        User user = null;
        //Optional<User> opt = Optional.of(user);
        Optional<User> opt = Optional.ofNullable(user);
        User user1 = opt.get();
        System.out.println(user1.toString());
    }

    ///在 Java 8 之前，任何访问对象方法或属性的调用都可能导致 NullPointerException：

    /*private static void JDK8OldPressNull() {
        String isocode = user.getAddress().getCountry().getIsocode().toUpperCase();
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isocode = country.getIsocode();
                    if (isocode != null) {
                        isocode = isocode.toUpperCase();
                    }
                }
            }

        }
    }*/

}
