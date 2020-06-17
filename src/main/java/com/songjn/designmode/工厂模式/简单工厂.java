package com.songjn.designmode.工厂模式;


import org.junit.jupiter.api.Test;

/**
 * 简单工厂模式
 */
public class 简单工厂 {
    @Test
    public void test() {
        Shape shape = ShapeFactory.getShape("rect");
        shape.draw();
    }
}


class ShapeFactory {
    public static final String TAG = "ShapeFactory";

    public static Shape getShape(String type) {
        Shape shape = null;
        if (type.equalsIgnoreCase("circle")) {
            shape = new CircleShape();
        } else if (type.equalsIgnoreCase("rect")) {
            shape = new RectShape();
        } else if (type.equalsIgnoreCase("triangle")) {
            shape = new TriangleShape();
        }
        return shape;
    }
}

interface Shape {
    void draw();
}

class CircleShape implements Shape {

    public CircleShape() {
        System.out.println("CircleShape: created");
    }

    @Override
    public void draw() {
        System.out.println("draw: CircleShape");
    }
}

class RectShape implements Shape {
    public RectShape() {
        System.out.println("RectShape: created");
    }

    @Override
    public void draw() {
        System.out.println("draw: RectShape");
    }
}

class TriangleShape implements Shape {

    public TriangleShape() {
        System.out.println("TriangleShape: created");
    }

    @Override
    public void draw() {
        System.out.println("draw: TriangleShape");
    }
}

