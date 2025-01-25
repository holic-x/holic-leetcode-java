package com.noob.algorithm.leetcode.q301_400.q309;

/**
 * 🟡 309 买卖股票的最佳时机含冷冻期 - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class Solution1 {

    /**
     * 多次交易，但需注意卖出股票后不能在第二天买入股票
     * 定义每个交易日的各个状态，并分析状态转移过程
     * dp[i][0]: 持有
     * dp[i][1]: 不持有（状态保持）
     * dp[i][2]: 不持有（今日卖出）
     * dp[i][3]: 冷冻
     */
    public int maxProfit(int[] prices) {
        int m = prices.length;

        // 1.dp 定义: dp[i][j] 表示第i日交易后为状态j的余下最大金额
        int[][] dp = new int[m][4];

        /**
         * 2.dp 递推
         * 0(持有)：
         * - 昨日已持有，继续保持：dp[i][0] = dp[i-1][0]
         * - 昨日未持有，买入（不持有状态下买入，冷冻状态下买入）：dp[i][0] = max{dp[i-1][1],dp[i-1][3]}-prices[i]
         *
         * 1(不持有（状态保持）):
         * - 昨日未持有，继续保持：dp[i][1] = dp[i-1][1]
         * - 冷冻期切换：dp[i][1] = dp[i-1][3]
         *
         * 2不持有（今日卖出）:
         * - 昨日持有，今日卖出：dp[i][2] = dp[i-1][0] + prices[i]
         *
         * 3(冷冻期)：
         * - 由不持有（今日卖出）状态切换：dp[i][3] = dp[i-1][2]
         */

        // 3.dp 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        // 返回结果
        return Math.max(dp[m - 1][3], Math.max(dp[m - 1][1], dp[m - 1][2]));
    }
}
