package com.songjn.optimize_IfElse.sharedemo.for_map;

import com.songjn.optimize_IfElse.sharedemo.Constant;
import com.songjn.optimize_IfElse.sharedemo.for_duotai.Image;
import com.songjn.optimize_IfElse.sharedemo.for_duotai.Link;
import com.songjn.optimize_IfElse.sharedemo.for_duotai.ShareItem;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc
 */
public class TestMap {
    private Map<Integer, Class<? extends ShareItem>> map = new HashMap<>();

    private void init() {
        map.put(Constant.TYPE_LINK, Link.class);
        map.put(Constant.TYPE_IMAGE, Image.class);
        //map.put(Constant.TYPE_TEXT, Text.class);
        //map.put(Constant.TYPE_IMAGE_TEXT, ImageText.class);
    }

    public ShareItem createShareItem(int type) {
        try {
            Class<? extends ShareItem> shareItemClass = map.get(type);
            return shareItemClass.newInstance();
        } catch (Exception e) {
            //return new DefaultShareItem(); // 返回默认实现，不要返回null
            return null; // 返回默认实现，不要返回null
        }
    }
}
