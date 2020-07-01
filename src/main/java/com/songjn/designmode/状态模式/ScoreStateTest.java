package com.songjn.designmode.状态模式;

public class ScoreStateTest {
    public static void main(String[] args) {
        ScoreContext account = new ScoreContext();
        System.out.println("学生成绩状态测试：");
        account.add(30);
        account.add(40);
        account.add(25);
        account.add(-15);
        account.add(-25);
    }
}

//环境类
class ScoreContext {
    private 成绩 state;

    ScoreContext() {
        state = new LowState(this);
    }

    public void setState(成绩 state) {
        this.state = state;
    }

    public 成绩 getState() {
        return state;
    }

    public void add(int score) {
        state.addScore(score);
    }
}

//抽象状态类
abstract class 成绩 {
    protected ScoreContext hj;  //环境
    protected String stateName; //状态名
    protected int score; //分数

    public abstract void checkState(); //检查当前状态

    public void addScore(int x) {
        score += x;
        System.out.print("加上：" + x + "分，\t当前分数：" + score);
        checkState();
        System.out.println("分，\t当前状态：" + hj.getState().stateName);
    }
}

//具体状态类：不及格
class LowState extends 成绩 {
    public LowState(ScoreContext h) {
        hj = h;
        stateName = "不及格";
        score = 0;
    }

    public LowState(成绩 state) {
        hj = state.hj;
        stateName = "不及格";
        score = state.score;
    }

    public void checkState() {
        if (score >= 90) {
            hj.setState(new HighState(this));
        } else if (score >= 60) {
            hj.setState(new MiddleState(this));
        }
    }
}

//具体状态类：中等
class MiddleState extends 成绩 {
    public MiddleState(成绩 state) {
        hj = state.hj;
        stateName = "中等";
        score = state.score;
    }

    public void checkState() {
        if (score < 60) {
            hj.setState(new LowState(this));
        } else if (score >= 90) {
            hj.setState(new HighState(this));
        }
    }
}

//具体状态类：优秀
class HighState extends 成绩 {
    public HighState(成绩 state) {
        hj = state.hj;
        stateName = "优秀";
        score = state.score;
    }

    public void checkState() {
        if (score < 60) {
            hj.setState(new LowState(this));
        } else if (score < 90) {
            hj.setState(new MiddleState(this));
        }
    }
}