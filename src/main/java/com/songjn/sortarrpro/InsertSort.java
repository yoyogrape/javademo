package com.songjn.sortarrpro;

/**
 * @author songjn
 * @create 2018-06-01 21:30
 * @desc 插入算法
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {34, 45, 21, 2, 44, 23, 87};//需要排序的数组
        for (int i = 0; i < nums.length; i++) {//轮数
            int temp = nums[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];

                } else {
                    break;
                }
            }
            if (nums[j + 1] != temp) {
                nums[j + 1] = temp;
            }
        }
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
