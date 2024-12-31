package com.noob.algorithm.leetcode.q152;

import java.util.Arrays;

/**
 * 152.乘积最大子数组
 */
public class Solution {

    public int maxProduct(int[] nums) {
        // 1.定义dp（dp[k]表示以nums[k]结尾的子数组的最大乘积）
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        // 2.状态转化方程（区分nums[i]为正数、负数的情况）

        // 3.初始化dp数组
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0]; // 记录最大值（在遍历过程中记录，不需要额外遍历dp数组） int max = Integer.MIN_VALUE;

        // 4.循环遍历nums数组元素，计算累乘的最大值
        for (int i = 1; i < nums.length; i++) {
            // 记录最大乘积和最小乘积 (数据的乘积都是从dpMax[i-1]*nums[i]、nums[i]、dpMin[i-1]*nums[i] 这三种情况分析，因此不需单独拆分)
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(nums[i], dpMin[i - 1] * nums[i]));
            // 遍历过程中更新max
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
