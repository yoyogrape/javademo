package com.songjn.moli_java8_test;

import lombok.Data;

/**
 * @auther songjn1
 * @create 2019-03-22
 * @desc
 */
@Data
public class Button {
    private Long id;
    private String name;
    private String showName;
    public Button(){}
    public Button(Long id, String name, String showName) {
        this.id = id;
        this.name = name;
        this.showName = showName;
    }

}
