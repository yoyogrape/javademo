package com.songjn.UUID;

import java.util.UUID;

/**
 * @auther songjn1
 * @date 2018/12/4
 * @desc
 */
public class UUIDTest {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        System.out.println(id);
    }
}
