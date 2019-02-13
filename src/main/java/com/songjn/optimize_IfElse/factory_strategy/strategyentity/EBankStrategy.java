package com.songjn.optimize_IfElse.factory_strategy.strategyentity;

import com.songjn.optimize_IfElse.factory_strategy.RechargeTypeEnum;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc  网银充值
 */
public class EBankStrategy implements Strategy {
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge*0.85;
    }

}
