package com.songjn.optimize_IfElse.factory_strategy.strategyentity;

import com.songjn.optimize_IfElse.factory_strategy.RechargeTypeEnum;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc
 */
public interface Strategy {
    Double calRecharge(Double charge, RechargeTypeEnum type);
}
