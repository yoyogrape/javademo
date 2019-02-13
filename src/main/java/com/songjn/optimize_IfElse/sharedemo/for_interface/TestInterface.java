package com.songjn.optimize_IfElse.sharedemo.for_interface;

import com.songjn.optimize_IfElse.sharedemo.Constant;
import com.songjn.optimize_IfElse.sharedemo.ShareItem;
import com.songjn.optimize_IfElse.sharedemo.ShareListener;
import org.springframework.util.StringUtils;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc 利用接口对if_else进行优化
 */
public class TestInterface {
    public void share(ShareItem item, ShareListener listener) {
        if (item == null) {
            if (listener != null) {
                listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
            }
            return;
        }

        if (listener == null) {
            listener = new ShareListener() {
                @Override
                public void onCallback(int state, String msg) {
                    //Log.i("DEBUG", "ShareListener is null");
                }
            };
        }

        shareImpl(item, listener);
    }

    private void shareImpl(ShareItem item, ShareListener listener) {
        if (item.type == Constant.TYPE_LINK) {
            // 分享链接
            if (!StringUtils.isEmpty(item.link) && !StringUtils.isEmpty(item.title)) {
                doShareLink(item.link, item.title, item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == Constant.TYPE_IMAGE) {
            // 分享图片
            if (!StringUtils.isEmpty(item.imagePath)) {
                doShareImage(item.imagePath, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == Constant.TYPE_TEXT) {
            // 分享文本
            if (!StringUtils.isEmpty(item.content)) {
                doShareText(item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else if (item.type == Constant.TYPE_IMAGE_TEXT) {
            // 分享图文
            if (!StringUtils.isEmpty(item.imagePath) && !StringUtils.isEmpty(item.content)) {
                doShareImageAndText(item.imagePath, item.content, listener);
            } else {
                listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
            }
        } else {
            listener.onCallback(ShareListener.STATE_FAIL, "不支持的分享类型");
        }
    }

    private void doShareImage(String imagePath, ShareListener listener) {

    }

    private void doShareText(String content, ShareListener listener) {

    }

    private void doShareImageAndText(String imagePath, String content, ShareListener listener) {

    }

    private void doShareLink(String link, String title, String content, ShareListener listener) {

    }

}
