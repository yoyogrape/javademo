package com.songjn.optimize_IfElse.factory_strategy;

import com.songjn.optimize_IfElse.factory_strategy.strategyentity.Strategy;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc  策略上下文
 */
public class Context {

    private Strategy strategy;

    public Double calRecharge(Double charge, Integer type) {
        strategy = StrategyFactory.getInstance().creator(type);
        return strategy.calRecharge(charge, RechargeTypeEnum.valueOf(type));
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}
