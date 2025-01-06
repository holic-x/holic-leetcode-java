package com.noob.algorithm.leetcode.q122;

/**
 * 🟡 122.买卖股票的最佳时机II（可多次操作股票） - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Solution1 {

    // 思路：利润拆解（记录每次低买高卖的正利润操作）买卖股票的最佳时机II（可多次操作同一只股票）
    public int maxProfit(int[] prices) {
        // 记录最大利润值
        int maxProfit = 0;
        // 一次遍历的过程，叠加每次低买高卖的正利润操作（从第2天开始可以卖前一天的票,且首日是没有利润的）
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(prices[i] - prices[i - 1], 0);
        }
        // 返回结果
        return maxProfit;
    }

}
