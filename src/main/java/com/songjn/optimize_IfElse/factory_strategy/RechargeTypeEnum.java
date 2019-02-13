package com.songjn.optimize_IfElse.factory_strategy;

/**
 * @auther songjn1
 * @create 2019-02-12
 * @desc
 */
public enum RechargeTypeEnum {

    E_BANK(1, "网银"),

    BUSI_ACCOUNTS(2, "商户账号"),

    MOBILE(3,"手机卡充值"),

    CARD_RECHARGE(4,"充值卡");

    private int value;

    private String description;

    RechargeTypeEnum(int value, String description) {
//        this.value = value;
//        this.description = description;
    }

    public int value() {
        return value;
    }
    public String description() {
        return description;
    }

    public static RechargeTypeEnum valueOf(int value) {
        for(RechargeTypeEnum type : RechargeTypeEnum.values()) {
            if(type.value() == value) {
                return type;
            }
        }
        return null;
    }
}
