package com.noob.algorithm.leetcode.q601_q700;

import java.util.Arrays;

/**
 * 🟢 674 最长连续递增序列 - https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/
 */
public class Solution1 {

    /**
     * 动态规划：
     */
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        // 1.dp 定义：dp[i] 表示以当前位置i结尾的元素构成的连续子序列长度
        int[] dp = new int[n];

        /**
         * 2.dp 递推:
         * - 判断当前位置i是否可以拼接在上一个序列中（检验是否满足连续递增的关系），如果不行则自成一派
         */

        // 3.dp 初始化
        Arrays.fill(dp, 1);

        // 4.dp 构建
        int maxLen = 1;
        for (int i = 1; i < n; i++) { // 外层遍历i，确定以i位置元素结尾的序列
            if (nums[i] > nums[i - 1]) {
                // 判断是否满足连续递增
                // dp[i] = dp[i-1] + 1;
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        // 返回结果
        return maxLen;
    }
}
