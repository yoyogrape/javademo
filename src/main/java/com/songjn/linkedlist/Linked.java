package com.songjn.linkedlist;

/**
 * @author songjn
 * @create 2018-06-04 21:11
 * @desc 链表
 *
 * 一种常见的基础数据结构，是一种线性表现，但是不会按照线性的顺序储存数据。
 * 而是在每一个节点里面存的是下一个节点的指针。
 **/
public class Linked {
    public static void main(String[] args) {
        NodeManager nodeManager = new NodeManager();
        nodeManager.add(5);
        nodeManager.add(4);
        nodeManager.add(3);
        nodeManager.add(2);
        nodeManager.add(1);
    }
}

class NodeManager {
    private Node root;//根节点

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    public void del() {

    }

    public void print() {

    }

    public void find() {

    }

    public void update() {

    }

    public void insert() {

    }


    private class Node {//谁拥有数据谁提供方法
        private int data;//用来存放节点。
        private Node next;//把当前的类型作为属性。

        public Node(int data) {
            this.data = data;
        }

        //data的get方法
        public int getData() {
            return data;
        }

        //data的set方法
        public void setData(int data) {
            this.data = data;
        }

        //添加节点
        public void addNode(int data) {
            if (this.next == null) {//判断第二个节点是否为空
                this.next=new Node(data);//为空，将data给第二个节点
            }else{
                this.next.addNode(data);
            }
        }

        //删除节点
        public void delNode(int data) {

        }

        //输出所有节点
        public void printNode(int data) {

        }

        //查找节点
        public Boolean findNode(int data) {
            return false;
        }

        //修改节点
        public void updateNode(int data) {

        }

        //插入节点
        public void insertNode(int data) {

        }
    }
}