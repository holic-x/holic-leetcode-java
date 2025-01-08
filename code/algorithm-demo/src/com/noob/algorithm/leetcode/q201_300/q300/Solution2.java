package com.noob.algorithm.leetcode.q201_300.q300;

import java.util.Arrays;

/**
 * 🟡 300 最长递增子序列 - https://leetcode.cn/problems/longest-increasing-subsequence/description/
 */
public class Solution2 {

    /**
     * 最长递增子序列
     * 思路：动态规划(空间优化版本)
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 1.dp 定义：dp[i] 表示以i位置元素结尾的最长子序列长度
        int[] dp = new int[n];

        /**
         *  2.dp 递推
         *  dp[i]: 对于i位置元素，需要判断其可以接在之前的哪个位置可以构成更长的序列（需要遍历前面的j元素）
         */

        // 3.dp 初始化
        Arrays.fill(dp, 1); // dp元素初始化为1

        // 4.dp 构建
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 判断j位置中是否存在比i位置元素小的子序列
                if (nums[j] < nums[i]) {
                    // 可构成更长序列的前提下更新值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        // 返回结果
        return max;
    }

}
