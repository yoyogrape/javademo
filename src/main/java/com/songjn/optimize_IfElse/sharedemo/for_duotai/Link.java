package com.songjn.optimize_IfElse.sharedemo.for_duotai;

import com.songjn.optimize_IfElse.sharedemo.Constant;
import com.songjn.optimize_IfElse.sharedemo.ShareListener;
import org.springframework.util.StringUtils;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc 将每一个都做成实体类然后实现父类
 */
public class Link extends ShareItem {
    String title;
    String content;
    String link;

    public Link(String link, String title, String content) {
        super(Constant.TYPE_LINK);
        this.link = !StringUtils.isEmpty(link) ? link : "default";
        this.title = !StringUtils.isEmpty(title) ? title : "default";
        this.content = !StringUtils.isEmpty(content) ? content : "default";
    }

    @Override
    public void doShare(ShareListener listener) {
        // do share
    }
}
