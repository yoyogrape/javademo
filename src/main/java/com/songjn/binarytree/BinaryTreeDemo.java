package com.songjn.binarytree;

/**
 * @author songjn
 * @create 2018-06-08 23:40
 * @desc 二叉树  中序遍历
 **/
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(9);
        binaryTree.add(0);
        binaryTree.add(5);
        //输出
        binaryTree.print();
    }
}

class BinaryTree {

    private Node root;

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    public void print() {
        root.printNode();
    }

    //内部类节点
    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public void addNode(int data) {
            //如果传进来的值小于当前值，放在左边
            if (this.data > data) {
                //左边的值是否为空
                if (this.left == null) {
                    this.left = new Node(data);
                } else {
                    //调用递归
                    this.left.addNode(data);
                }
            } else {
                //否则将当前值放在右面
                if (this.right == null) {
                    this.right = new Node(data);
                } else {
                    this.right.addNode(data);
                }
            }

        }

        //中序遍历输出节点
        public void printNode() {
            if (this.left != null) {
                this.left.printNode();
            }
            //只有中间才能输出
            System.out.print(this.data + "-->");
            if (this.right != null) {
                this.right.printNode();
            }
        }
    }
}