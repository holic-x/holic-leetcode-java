package com.noob.algorithm.leetcode.q701_800.q714;

/**
 * 🟡 714 买卖股票的最佳时机含手续费 - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 */
public class Solution1 {

    /**
     * 多次操作股票，一笔交易（包含一次买入+一次卖出操作）只需要支付一次手续费
     * 手续费计算：可以择选在每次买入或者卖出的时候补充手续费计算
     * 0-持有：
     * - 昨日已持有，继续保持：dp[i][0] = dp[i-1][0]
     * - 昨日未持有，今日买入：dp[i][1] = dp[i-1][1] - prices[i]
     * 1-未持有：
     * - 昨日未持有，继承状态：dp[i][1] = dp[i-1][1]
     * - 昨日已持有，今日卖出（卖出时计算手续费）：dp[i][1] = dp[i-1][0] + prices[i] - fee;
     */
    public int maxProfit(int[] prices, int fee) {
        int m = prices.length;
        // 1.dp 定义：dp[i][j] 表示第i日状态为j的剩余最大现金
        int[][] dp = new int[m][2];

        // 2.dp 递推

        // 3.dp 初始化
        dp[0][0] = -prices[0]; // 买入股票进入持有态
        dp[0][1] = 0;

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        // 返回结果
        return dp[m - 1][1];
    }
}
