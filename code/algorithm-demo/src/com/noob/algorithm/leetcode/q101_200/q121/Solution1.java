package com.noob.algorithm.leetcode.q101_200.q121;

/**
 * 🟢 121.买卖股票的最佳时机（只能做一次买卖操作） - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution1 {

    // 思路1：暴力法
    public int maxProfit(int[] prices) {
        // 依次遍历判断任意两个元素之间的差值，记录最大利润值
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) { // 卖出时间要晚于买入时间
                if (prices[j] > prices[i]) { // 至少要获取利润
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        // 返回结果
        return maxProfit;
    }

}
