package com.songjn.gof;

/**
 * @author songjn
 * @create 2018-06-03 16:41
 * @desc 策略模式
 *
 * 解释：定义一系列算法，将每一个算法封装起来并可以相互替换使用。
 * 策略模式让算法独立于使用它的客户应用而独立变化。
 *
 * 核心：将可变的行为抽象出来，可以在真正使用的时候相互替换。
 *
 * 例子：文件保存，可以将文件保存到文件中，网络。不同的地方用到不同的策略。
 **/
public class StrategyPattern{
    public static void main(String[] args) {
        BaseService baseService = new BaseServiceImpl();
        baseService.setBaseSave(new FileSave());
        baseService.add("haha");
    }
}

interface BaseSave{
     void saveFile(String data);
}

class FileSave implements BaseSave{
    @Override
    public void saveFile(String data) {
        System.out.println("将数据保存到文件中。。。");
    }
}
class NetworkSave implements BaseSave{
    @Override
    public void saveFile(String data) {
        System.out.println("将数据保存到网络中。。。");
    }
}

abstract class BaseService {
    private BaseSave baseSave;
    public void setBaseSave(BaseSave baseSave) {
        this.baseSave = baseSave;
    }

    public void add(String data){
        System.out.println("检查数据完整性。");
        baseSave.saveFile(data);
        System.out.println("保存数据"+data);
    }
}

class BaseServiceImpl extends BaseService {

}