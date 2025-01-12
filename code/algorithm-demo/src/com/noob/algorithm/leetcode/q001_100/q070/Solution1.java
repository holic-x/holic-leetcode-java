package com.noob.algorithm.leetcode.q001_100.q070;

/**
 * 🟢 70.爬楼梯 - https://leetcode.cn/problems/climbing-stairs/
 */
public class Solution1 {

    // 动态规划思路
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // 定义初始结果
        dp[0] = 1;
        dp[1] = 1;

        // 爬N阶的思路（f(n) = f(n-1) + f(n-2)）
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回爬n阶的方案(数组从0开始计数)
        return dp[n];
    }

}
