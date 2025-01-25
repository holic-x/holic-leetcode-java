package com.noob.algorithm.leetcode.q101_200.q123;

/**
 * 🔴 123 买卖股票的最佳时机III - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class Solution1 {
    /**
     * 动态规划：设定每日的操作状态，基于前置状态进行推导
     * `dp`定义：`dp[i][j]` 表示第`i`天不同状态下的剩余的最大现金
     * dp[i][0] 无操作
     * dp[i][1] 第1次持有
     * dp[i][2] 第1次不持有
     * dp[i][3] 第2次持有
     * dp[i][4] 第2次不持有
     */
    public int maxProfit(int[] prices) {
        // 1.dp 构建
        int[][] dp = new int[prices.length][5];

        /**
         * 2.dp 推导（根据昨日持有股票的状态进行推导，已持有或未持有）
         * dp[i][0]: 无操作
         * dp[i][1]：继续持有 或 第1次买入 max{dp[i-1][1],0-prices[i]}
         * dp[i][2]：继承状态 或 基于第1次买入进行卖出 max{dp[i-1][2],dp[i-1][1]+prices[i]}
         * dp[i][3]：继续持有 或 第2次买入（需将第1次卖出） max{dp[i-1][3],dp[i-1][2]-prices[i]}
         * dp[i][4]：继承状态 或 基于第2次买入进行卖出 max{dp[i-1][4],dp[i-1][3]+prices[i]}
         */

        // 3.dp 初始化
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0]; // 第1次只能买入
        dp[0][2] = 0; // 日内买入卖出，无利润
        dp[0][3] = 0 - prices[0]; // 相当于日内买入卖出各一次相互抵消，随后再次买入视作第2次买入
        dp[0][4] = 0; // 日内执行两次买入卖出的组合操作，无利润

        // 4.dp 构建（遍历顺序）
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]); // Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        // 返回最大利润（最后一天状态为第2次不持有的状态下可获得最大利润）
        return dp[prices.length - 1][4];
    }

}
