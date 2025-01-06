package com.noob.algorithm.leetcode.q121;

/**
 * 🟢 121.买卖股票的最佳时机（只能做一次买卖操作） - https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution2 {

    // 思路2：贪心算法
    public int maxProfit(int[] prices) {
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

}
