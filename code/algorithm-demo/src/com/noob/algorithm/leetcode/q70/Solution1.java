package com.noob.algorithm.leetcode.q70;

/**
 * 70.爬楼梯
 */
public class Solution1 {

    // 动态规划思路
    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        // 定义初始结果
        dp[0] = 1;
        dp[1] = 1;

        // 爬N阶的思路（f(n) = f(n-1) + f(n-2)）
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回爬n阶的方案(数组从0开始计数)
        return dp[n - 1];
    }

    // 动态数组优化
    public int climbStairs2(int n) {
        // 定义指针
        int p = 1, q = 1, r = 2;
        if (n == 0) return p;
        if (n == 1) return q;
        if (n == 2) return r;
        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        // 返回爬n阶的方案(数组从0开始计数)
        return r;
    }

    public int climbStairs(int n) {
        // 定义指针
        int p = 0, q = 0, r = 1;

        // 爬N阶的思路（f(n) = f(n-1) + f(n-2)）
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        // 返回爬n阶的方案(数组从0开始计数)
        return r;
    }
}
