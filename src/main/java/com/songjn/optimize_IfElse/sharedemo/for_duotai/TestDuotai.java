package com.songjn.optimize_IfElse.sharedemo.for_duotai;

import com.songjn.optimize_IfElse.sharedemo.ShareListener;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc 利用多态的方式解决多if_else
 */
public class TestDuotai {
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

    private void shareImpl (ShareItem item, ShareListener listener) {
        item.doShare(listener);
    }
}
