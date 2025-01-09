package com.noob.algorithm.leetcode.q001_100.q042;

/**
 * 🔴 042 接雨水 - https://leetcode.cn/problems/trapping-rain-water/description/
 */
public class Solution1 {

    /**
     * 思路分析：动态规划思路
     */
    public int trap(int[] height) {
        int n = height.length;
        // 定义left[]：left[i]表示i位置的最大左前缀
        int[] left = new int[n];
        left[0] = height[0]; // 初始化
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // 定义right[]：right[i]表示i位置的最大右后缀
        int[] right = new int[n];
        right[n - 1] = height[n - 1]; // 初始化
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // 获取最大可接雨水量
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (Math.min(left[i], right[i]) - height[i]);
        }

        // 返回结果
        return res;
    }

}
