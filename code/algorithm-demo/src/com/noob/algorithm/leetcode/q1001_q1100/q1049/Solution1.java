package com.noob.algorithm.leetcode.q1001_q1100.q1049;

/**
 * 🟡 1049 最后一块石头的重量II - https://leetcode.cn/problems/last-stone-weight-ii/
 */
public class Solution1 {

    /**
     * 思路分析：0-1 背包问题
     */
    public int lastStoneWeightII(int[] stones) {
        // 遍历元素，获取石头重量总和
        int weightSum = 0;
        for (int weight : stones) {
            weightSum += weight;
        }

        // 背包容量设置为石头总量的一半
        int bagSize = weightSum / 2;


        // 1.dp 定义：dp[i][j] 表示从[0,i]中选择元素装入背包的最大价值
        int m = stones.length, n = bagSize + 1;
        int[][] dp = new int[m][n];

        /**
         * 2.dp 递推：
         * dp[i][j] = max{dp[i-1][j],dp[i-1][j-weight[i]] + weight[i]}
         */

        // 3.dp 初始化
        // 首行初始化：
        for (int j = 0; j < n; j++) {
            dp[0][j] = (j >= stones[0] ? stones[0] : 0); // 如果可以放下物品0则放置，无法放下则最大价值为0
        }

        // 首列初始化：对于容量j为0的情况下无法放置任何物品
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        // 4.dp 构建
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }

        // 返回结果
        return weightSum - 2 * dp[m - 1][bagSize];
    }
}
