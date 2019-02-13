package com.songjn.optimize_IfElse.sharedemo;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc 分享——接口
 */
public interface ShareListener {

    int STATE_SUCC = 0;
    int STATE_FAIL = 1;

    void onCallback(int state, String msg);
}