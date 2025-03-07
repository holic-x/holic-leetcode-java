package com.noob.algorithm.leetcode.q001_100.q041;

import java.util.Arrays;

/**
 * 🔴 041 缺失的第1个正数 - https://leetcode.cn/problems/first-missing-positive/
 */
public class Solution3 {
    /**
     * 给定一个未排序的数组nums，找出其中没有出现的最小正整数（题目限定时间复杂度为O(n),且只能使用常数级别的空间）
     * 思路③：排序+遍历排序后的数组
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 对数组元素进行排序
        Arrays.sort(nums);

        int cur = 1; // 从1开始
        // 遍历排序后的集合
        for (int i = 0; i < n; i++) {
            if (nums[i] == cur) {
                cur++; // 如果排序后的元素值与当前cur元素相同，则继续寻找下一个正数
            }
        }
        return cur;
    }

}
