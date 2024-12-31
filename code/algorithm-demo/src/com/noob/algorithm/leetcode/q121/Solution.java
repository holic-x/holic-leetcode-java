package com.noob.algorithm.leetcode.q121;

/**
 * 121.买卖股票的最佳时机（只能做一次买卖操作）
 */
public class Solution {

    // 思路3：利润拆解（记录每次低买高卖的正利润操作）买卖股票的最佳时机II（可多次操作同一只股票）
    /*
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
     */

    // 思路2：贪心算法
    public int maxProfit2(int[] prices) {
        // 记录最大利润值
        int maxProfit = 0;
        // 记录股票的历史价格最低点（非全局最低点）
        int hisMinPrice = Integer.MAX_VALUE;
        // 一次遍历的过程中记录hisMinPrice的同时，并假设每天如果是在hisMinPrice位置买入然后执行卖出的利润，考虑所有的天数并同步更新最大利润值
        for (int i = 0; i < prices.length; i++) {
            // 计算假设在hisMinPrice位置买入，今天卖出股票能得到的利润值，并更新maxProfit
            maxProfit = Math.max(maxProfit, prices[i] - hisMinPrice);
            // 更新历史记录最低点
            hisMinPrice = Math.min(hisMinPrice, prices[i]);
        }
        // 返回结果
        return maxProfit;
    }

    // 思路1：暴力法
    public int maxProfit1(int[] prices) {
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
