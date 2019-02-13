package com.songjn.optimize_IfElse.factory_strategy.strategyentity;

import com.songjn.optimize_IfElse.factory_strategy.RechargeTypeEnum;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc  商户账户充值
 */
public class BusiAcctStrategy  implements Strategy {
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        // TODO Auto-generated method stub
        return charge*0.90;
    }
}
