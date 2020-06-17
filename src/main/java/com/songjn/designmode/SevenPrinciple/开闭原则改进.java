package com.songjn.designmode.SevenPrinciple;

public class 开闭原则改进 {
    public static void main(String[] args) {
//使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.draw(new Rectangle());
        graphicEditor.draw(new Rectangle());
        graphicEditor.draw(new Rectangle());
    }
}

//这是一个用于绘图的类 [使用方]
class GraphicEditor {
    //接收 Shape 对象，然后根据 type，来绘制不同的图形
    public void draw(Shape s) {
        s.draw();
    }
}

//Shape 类，基类
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    //绘制矩形
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class Circle implements Shape {
    //绘制圆形
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

//新增画三角形
class Triangle implements Shape {
    //绘制三角形
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}
