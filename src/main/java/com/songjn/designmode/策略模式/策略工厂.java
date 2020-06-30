package com.songjn.designmode.策略模式;

import java.util.HashMap;

public class 策略工厂 {
    public static void main(String[] args) {
        ToAgentStrategyFactory.exeToAgentStrategy("moli");
    }
}

/**
 * 转人工策略接口
 */
interface ToAgentStrategy {
    void agentStrategy();
}

class moliToAgentStrategy implements ToAgentStrategy {
    @Override
    public void agentStrategy() {
        System.out.println("。。。执行moli转人工策略。。。");
    }
}

class lenaToAgentStrategy implements ToAgentStrategy {
    @Override
    public void agentStrategy() {
        System.out.println("。。。执行lena转人工策略。。。");
    }
}

/**
 * 转人工工厂
 */
class ToAgentStrategyFactory {
    private static HashMap<String, ToAgentStrategy> agentMap = new HashMap<>();

    static {
        agentMap.put("moli", new moliToAgentStrategy());
        agentMap.put("lena", new lenaToAgentStrategy());
    }

    public void put(String agent, ToAgentStrategy agentStrategy) {
        agentMap.put(agent, agentStrategy);
    }

    public ToAgentStrategy get(String agent) {
        return agentMap.get(agent);
    }

    public static void exeToAgentStrategy(String agent) {
        agentMap.get(agent).agentStrategy();
    }

}