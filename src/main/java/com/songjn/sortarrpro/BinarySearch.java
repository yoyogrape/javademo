package com.songjn.sortarrpro;

/**
 * @author songjn
 * @create 2018-06-01 22:15
 * @desc 二分查找
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {10, 20, 40, 60, 78, 90};
        System.out.println(myBinarySearch(nums, 60));
    }

    public static int myBinarySearch(int[] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;//>>>1
            if (nums[middle] > key) {
                end = middle - 1;
            } else if (nums[middle] < key) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
