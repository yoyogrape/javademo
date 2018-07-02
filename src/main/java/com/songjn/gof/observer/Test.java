package com.songjn.gof.observer;

/**
 * @author songjn
 * @create 2018-06-25 00:53
 * @desc 测试类
 **/
public class Test {
    @org.junit.jupiter.api.Test
    public  void testObserver(){
        Message message = new Message();
        Observer user1=new User("lili");
        Observer user2=new User("tom");
        Observer user3=new User("cat");
        message.registerObserver(user1);
        message.registerObserver(user2);
        message.registerObserver(user3);
        message.setMsg("hahaha");
    }
}
