package com.songjn.optimize_IfElse.sharedemo.for_duotai;

import com.songjn.optimize_IfElse.sharedemo.ShareListener;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc 抽象类ShareItem
 */
public abstract class ShareItem {
    int type;

    public ShareItem(int type) {
        this.type = type;
    }

    public abstract void doShare(ShareListener listener);
}