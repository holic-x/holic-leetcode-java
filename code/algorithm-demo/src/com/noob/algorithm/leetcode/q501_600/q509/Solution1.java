package com.noob.algorithm.leetcode.q501_600.q509;

/**
 * 🟢 509 斐波那契数 - https://leetcode.cn/problems/fibonacci-number/
 */
public class Solution1 {

    /**
     * 动态规划思路
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // 1.dp 定义：dp[i]表示第i个斐波那契数
        int[] dp = new int[n + 1]; // 如果需要计算到n则数组长度取值为n+1

        /**
         * 2.dp 递推：
         * f(0) = 0 ; f(1) = 1
         * f(n) = f(n-1) + f(n-2) (n＞1)
         */

        // 3.dp 初始化
        dp[0] = 0;
        dp[1] = 1;

        // 4.dp 构建
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 返回结果
        return dp[n];
    }

}
