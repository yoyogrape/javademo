package com.songjn.gof;

/**
 * @author songjn
 * @create 2018-06-03 10:37
 * @desc 模板方法模式
 * 解释：定义一个操作中的算法骨架。而将一些可变部分的实现延迟到子类中，
 * 模板方法模式使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定的步骤。
 * <p>
 * 例子：煎饼果子的制作，框架是固定的，卖给顾客的时候需要让顾客的想法参与进来。
 **/
public class TemplateMethod {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.action("haha", "del");
    }
}
//验证用户是否登录的代码在骨架中。不同的类实现可以有不同的execute执行。
abstract class BaseManager {
    public void action(String name, String method) {
        if ("admin".equals(name)) {
            execute(method);
        } else {
            System.out.println("你没有操作权限，请联系管理员。");
        }
    }
    //抽象方法，子类去实现，然后调用的时候执行action方法，就可以调用子类中实现的execute
    public abstract void execute(String method);
}

class UserManager extends BaseManager {
    public void execute(String method) {
        //用户是否登录验证。
        //登录后才能执行以下操作。
        if ("add".equals(method)) {
            System.out.println("执行了添加操作。");
        } else if ("del".equals(method)) {
            System.out.println("执行了删除操作。");
        }
    }
}