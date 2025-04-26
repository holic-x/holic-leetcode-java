package com.noob.algorithm.leetcode.q901_q1000.q977;

/**
 * 🟢 977 有序数组的平方 - https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 */
public class Solution977_01 {

    /**
     * 思路分析：
     * 双指针处理
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // 定义平方和的结果集，遍历顺序从左往右，填充顺序从右往左
        int[] ans = new int[n];

        // 定义数据填充指针位置
        int idx = n - 1; // 从后往前填充数据
        int left = 0, right = n - 1; // 双指针

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            // 判断当前遍历元素位置与当前填充位置指向的元素的平方和大小
            if (leftSquare > rightSquare) {
                ans[idx] = leftSquare;
                idx--;
                left++;
            } else {
                ans[idx] = rightSquare;
                idx--;
                right--;
            }
        }

        // 返回结果
        return ans;
    }
}
