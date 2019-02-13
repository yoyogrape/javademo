package com.songjn.combination;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc 工厂
 */
public class Factory {

    private static Map<Integer, Zong> map = new HashMap<>();

    static {
        map.put(Fangshi.SHANGHU.i, new Zong_ShanghuImpl());
        map.put(Fangshi.SHOUJI.i, new Zong_ShoujiImpl());
        map.put(Fangshi.CARD.i, new Zong_CardImpl());
    }

    public static Zong get(Fangshi fangshi) {
        return map.get(fangshi.i);

    }

}
