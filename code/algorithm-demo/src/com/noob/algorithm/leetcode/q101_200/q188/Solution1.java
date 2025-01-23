package com.noob.algorithm.leetcode.q101_200.q188;

/**
 * 🔴 188 买卖股票的最佳时机IV - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/
 */
public class Solution1 {

    /**
     * 可完成k笔交易（买入k次，卖出k次），参考多次买入卖出交易股票的动态规划思路寻找通性
     * 0(无操作)、1(第①次持有)、2(第①次不持有) ..... 2*k(第k次持有)、2*k+1(第k次不持有)
     * dp[i][0] = dp[i-1][0]
     * 第①次持有：
     * - 昨日已持有，继续持有：dp[i][1] = dp[i-1][1]
     * - 昨日未持有，今日买入：dp[i][1] = dp[i-1][0] - prices[i]
     * 第①次不持有：
     * - 昨日未持有，继承状态：dp[i][2] = dp[i-1][2]
     * - 昨日已持有，今日卖出：dp[i][2] = dp[i-1][1] + prices[i]
     * 第②次持有：
     * - 昨日已持有，继续持有：dp[i][3] = dp[i-1][3]
     * - 昨日未持有，今日买入：dp[i][3] = dp[i-1][2] - prices[i]
     * 第②次不持有：
     * - 昨日未持有，继承状态：dp[i][4] = dp[i-1][4]
     * - 昨日已持有，今日卖出：dp[i][4] = dp[i-1][3] + prices[i]
     * <p>
     * 第K次持有：
     * - 昨日已持有，继续持有：dp[i][2*k-1] = dp[i-1][2*k-1]
     * - 昨日未持有，今日买入：dp[i][2*k-1] = dp[i-1][2*k-2] - prices[i]
     * 第K次不持有：
     * - 昨日未持有，继承状态：dp[i][2*k] = dp[i-1][2*k]
     * - 昨日已持有，今日卖出：dp[i][2*k] = dp[i-1][2*k-1] + prices[i]
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 1.dp 定义（dp[i][x]表示第i天操作后为x状态下的余下最大现金）
        int[][] dp = new int[n][2 * k + 1]; // 状态取值范围为[0,2k+1)

        // 2.dp 递推：基于上述公式进行递推，得到第i天下每次持有/不持有状态下的余下最大现金

        // 3.dp 初始化（初始化dp[0][0] - dp[0][k]）
        dp[0][0] = 0;
        for (int x = 1; x <= k; x++) {
            dp[0][2 * x - 1] = 0 - prices[0]; // 第0天的持有态：第1次买入/经过多轮操作抵消后的买入
            dp[0][2 * x] = 0; // 第0天的未持有态：经过多轮操作抵消
        }

        // 4.dp 构建
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0]; // 不操作
            // 遍历k次（k轮交易状态设定）
            for (int x = 1; x <= k; x++) {
                dp[i][2 * x - 1] = Math.max(dp[i - 1][2 * x - 1], dp[i - 1][2 * x - 2] - prices[i]);
                dp[i][2 * x] = Math.max(dp[i - 1][2 * x], dp[i - 1][2 * x - 1] + prices[i]);
            }
        }

        // 返回结果
        return dp[n - 1][2 * k];

    }
}
