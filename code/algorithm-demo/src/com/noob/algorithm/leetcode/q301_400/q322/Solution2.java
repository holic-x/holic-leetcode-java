package com.noob.algorithm.leetcode.q301_400.q322;


/**
 * 🟡 322 零钱兑换 - https://leetcode.cn/problems/coin-change/description/
 */
public class Solution2 {

    /**
     * 思路：动态规划思路（基于二维数组思路实现）
     */
    public int coinChange(int[] coins, int amount) {
        int INF = amount + 1; // 设置一个最大值（不可能达到的最大值）
        int m = coins.length, n = amount + 1; // m 物品个数，n背包容量（取到amount）
        // 1.dp 定义：dp[i][j] 表示可以构成总金额j的最少的硬币个数
        int[][] dp = new int[m][n];

        /**
         * 2.dp 递推，dp[i][j] 对于每个硬币可以选择放入或者不放入
         * - 放入：j>coins[i] 可以选择放或者不放 dp[i][j] = min{dp[i-1][j],dp[i][j-coins[i]] + 1]}
         * - 不放入：j<coins[i] 无法放入，继承上一状态 dp[i][j] = dp[i-1][j]
         */

        // 3.dp 初始化
        // dp[0][j] 只能放入物品0(则关注物品0是否可以刚好组成金额j)
        for (int j = 0; j < n; j++) {
            dp[0][j] = (j % coins[0] == 0) ? (j / coins[0]) : INF;
        }

        // dp[i][0] 容量为0，无法放入任何硬币
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }

        // 返回结果
        return dp[m - 1][amount] >= INF ? -1 : dp[m - 1][amount];
    }
}
