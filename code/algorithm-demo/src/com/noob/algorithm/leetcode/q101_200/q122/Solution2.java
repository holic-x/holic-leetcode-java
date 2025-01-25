package com.noob.algorithm.leetcode.q101_200.q122;

/**
 * 🟡 122.买卖股票的最佳时机II（可多次操作股票） - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Solution2 {

    // 思路2：动态规划
    public int maxProfit(int[] prices) {
        int n = prices.length;
        /**
         * 1.dp 定义
         * dp[i][j] 表示第i天状态为j的情况下所能获取的最大现金数
         * dp[i][0]: 第i天【持有股票】的情况下所能获取的最大现金数
         * dp[i][1]: 第i天【不持有股票】的情况下所能获取的最大现金数
         */
        int[][] dp = new int[n][2];

        /**
         * 2.dp 推导（根据前一天持有股票的状态进行推导）
         * dp[i][0]：
         * - 昨日未持有，今日买入：dp[i][0] = dp[i-1][1] - prices[i] // 因为股票可以买入卖出操作多次，所以如果是买入操作需要基于昨日未持有状态进行推导
         * - 昨日已持有，继续保持：dp[i][0] = dp[i-1][0]
         * dp[i][1]：
         * - 昨日未持有，继续保持：dp[i][1] = dp[i-1][1]
         * - 昨日已持有，今日卖出：dp[i][1] = dp[i-1][0] + prices[i]
         */

        // 3.dp 初始化
        dp[0][0] = 0 - prices[0]; // 无前置状态推导，持有则需买入
        dp[0][1] = 0;

        // 4.dp 构建
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        // 返回最后1天不持有股票的状态即为所得最大现金数
        return dp[n - 1][1];
    }

}
