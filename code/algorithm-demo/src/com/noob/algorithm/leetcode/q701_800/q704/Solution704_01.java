package com.noob.algorithm.leetcode.q701_800.q704;

/**
 * 🟢 704 二分查找 - https://leetcode.cn/problems/binary-search/
 */
public class Solution704_01 {

    /**
     * 思路分析：
     * 二分查找算法（多种不同区间的二分检索）
     */
    public int search(int[] nums, int target) {
        return binarySearch1(nums, target);
        // return binarySearch2(nums,target);
        // return binarySearch3(nums,target);
    }

    // ① 闭区间[left,right]
    private int binarySearch1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        // 没有找到目标数
        return -1;
    }

    // ② 左闭右开区间[left,right)
    private int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        // 没有找到目标数
        return -1;
    }

    // ③ 开区间(left,right)
    private int binarySearch3(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid;
            }
        }
        // 没有找到目标数
        return -1;
    }

}
