package com.songjn.optimize_IfElse.sharedemo;

import org.springframework.util.StringUtils;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc demo1:用接口去掉简单的if-else
 *
 * 业务说明：
 * 简单分享的业务需求：
 * 支持分享链接、图片、文本和图文，分享结果回调给用户（为了不跑题，这里简略了业务，实际复杂得多）。
 */
public class TestClass {

    public void share (ShareItem item, ShareListener listener) {
        if (item != null) {
            if (item.type == Constant.TYPE_LINK) {
                // 分享链接
                if (!StringUtils.isEmpty(item.link) && ! StringUtils.isEmpty(item.title)) {
                    doShareLink(item.link, item.title, item.content, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            } else if (item.type == Constant.TYPE_IMAGE) {
                // 分享图片
                if (! StringUtils.isEmpty(item.imagePath)) {
                    doShareImage(item.imagePath, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            } else if (item.type == Constant.TYPE_TEXT) {
                // 分享文本
                if (! StringUtils.isEmpty(item.content)) {
                    doShareText(item.content, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            } else if (item.type == Constant.TYPE_IMAGE_TEXT) {
                // 分享图文
                if (! StringUtils.isEmpty(item.imagePath) && ! StringUtils.isEmpty(item.content)) {
                    doShareImageAndText(item.imagePath, item.content, listener);
                } else {
                    if (listener != null) {
                        listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                    }
                }
            } else {
                if (listener != null) {
                    listener.onCallback(ShareListener.STATE_FAIL, "不支持的分享类型");
                }
            }
        } else {
            if (listener != null) {
                listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
            }
        }
    }

    private void doShareImage(String imagePath, ShareListener listener) {

    }

    private void doShareImageAndText(String imagePath, String content, ShareListener listener) {

    }

    private void doShareText(String content, ShareListener listener) {
        
    }

    private void doShareLink(String link, String title, String content, ShareListener listener) {

    }

}
