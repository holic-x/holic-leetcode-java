package com.noob.algorithm.leetcode.q1401_q1500;

/**
 * 🟡 1423 可获得的最大点数 - https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/description/
 */
public class Solution1423_01 {

    /**
     * 给定cardPoints[],限定从开头或者末尾拿一张卡牌，最终必须正好拿k张卡牌，计算可获取的最大点数
     * 思路：固定一个n-k大小的滑动窗口，求滑动窗口中元素之和的min，用所有卡牌点数之和sum减去min即可得到拿走卡牌的最大值
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (n < k) {
            return -1;
        }
        // 定义固定大小的滑动窗口
        int left = 0, right = n - k; // 滑动窗口范围 [left,right]
        int winSum = 0, minWinSum = 0; // 定义窗口元素之和以及维护窗口中最小的元素和
        int totalSum = 0; // 定义所有元素总和

        //  计算初始化窗口状态
        for (int i = left; i <= right; i++) {
            winSum += cardPoints[i];
            totalSum += cardPoints[i];
        }
        minWinSum = winSum; // 初始化最小元素和

        while (right < n) {
            // 遍历到cardPoints[right]位置
            // 计算元素总和
            totalSum += cardPoints[right];
            // 窗口处理(加入右边元素，移除左侧元素)
            winSum -= cardPoints[left++];
            winSum += cardPoints[right++];
            // 一轮处理完成，更新minWinSum
            minWinSum = Math.min(minWinSum, winSum);
        }

        // 返回结果
        return totalSum - minWinSum;
    }

}
