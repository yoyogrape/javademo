package com.songjn.combination;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc
 */
public enum Fangshi {
    SHANGHU(1, "商户"),
    SHOUJI(2, "手机"),
    CARD(3, "充值卡");
    Integer i;

    Fangshi(Integer i, String desc) {
    }


    public Fangshi nage(Integer num) {
        for (Fangshi f : Fangshi.values()) {
            if (f.i.equals(num)) {
                return f;
            }
        }
        return null;
    }
}
