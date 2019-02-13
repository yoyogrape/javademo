package com.songjn.optimize_IfElse.factory_strategy.strategyentity;

import com.songjn.optimize_IfElse.factory_strategy.RechargeTypeEnum;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc  充值卡充值
 */

public class CardStrategy implements Strategy {
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge+charge*0.01;
    }

}
