package com.songjn.combination;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc
 */
public class Test {

    public static void main(String[] args) {

        final Zong zong = Factory.get(Fangshi.SHANGHU);
        final Double suan = zong.suan(100D);
        System.out.println(suan);
    }


}
