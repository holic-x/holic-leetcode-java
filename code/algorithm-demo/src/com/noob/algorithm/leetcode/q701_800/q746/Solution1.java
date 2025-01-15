package com.noob.algorithm.leetcode.q701_800.q746;

/**
 * 🟢 746 使用最小花费爬楼梯 - https://leetcode.cn/problems/min-cost-climbing-stairs/
 */
public class Solution1 {

    /**
     * 动态规划思路
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // 1.dp 定义（dp[i]表示达到第i阶所需花费的最小成本）
        int[] dp = new int[n + 1];

        /**
         * 2.dp 递推：到达第i阶的方案可以有两种可能：i-1阶走1阶、i-2阶走2阶，因此dp[i]花费最小成本可以从中择选
         * dp[i] = min{dp[i-1]+cost[i-1] , dp[i-2]+cost[i-2]}
         */

        // 3.dp 初始化
        dp[0] = 0; // 爬0阶原地不动，无需成本
        dp[1] = 0; // 误区：误认为爬1阶需要从第0阶跳过来，因此其成本为cost[0]，但实际上也可以选择1阶作为起始点出发，因此最小成本为0（因为题目并没有限定起点）

        // 4.dp 构建
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        // 返回达到顶部所需的最小花费
        return dp[dp.length - 1];
    }

}
