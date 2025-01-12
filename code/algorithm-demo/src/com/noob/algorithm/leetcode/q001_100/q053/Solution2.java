package com.noob.algorithm.leetcode.q001_100.q053;

/**
 * 🟡 53.最大子数组和 - https://leetcode.cn/problems/maximum-subarray/description/
 */
public class Solution2 {

    /**
     * dp 动态规划思路
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // 1.dp定义：dp[i] 表示以i位置元素结尾的子数组的最大和
        int[] dp = new int[len];

        // 2.dp递推：dp[i] = max {dp[i-1]+nums[i],nums[i]}

        // 3.dp初始化
        dp[0] = Math.max(Integer.MIN_VALUE, nums[0]);
        int maxVal = Math.max(Integer.MIN_VALUE, dp[0]);

        // 4.dp构建
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxVal = Math.max(maxVal, dp[i]);
        }

        // 返回结果
        return maxVal;
    }

}
