package com.songjn.sortarrpro;

/**
 * @author songjn
 * @create 2018-05-31 22:55
 * @desc 选择排序法
 **/

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {34, 45, 21, 2, 44, 23, 87};//需要排序的数组
        int minIndex = 0;//用于记录每次比较最小值的下表
        for (int i = 0; i < nums.length - 1; i++) {//轮数
            minIndex = i;//每轮最小下标
            //比较然后将最小下给最小数
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            //判断需要交换的数的下标是否为自己
            if (minIndex != i) {
                nums[minIndex] = nums[minIndex] ^ nums[i];
                nums[i] = nums[minIndex] ^ nums[i];
                nums[minIndex] = nums[minIndex] ^ nums[i];
            }
        }
        for (int n : nums) {//输出数组
            System.out.println(n);
        }
    }
}
