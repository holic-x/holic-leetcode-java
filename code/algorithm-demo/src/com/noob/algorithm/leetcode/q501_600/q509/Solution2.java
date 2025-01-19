package com.noob.algorithm.leetcode.q501_600.q509;

/**
 * 🟢 509 斐波那契数 - https://leetcode.cn/problems/fibonacci-number/
 */
public class Solution2 {

    /**
     * 动态规划思路：空间优化版本
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int p = 0; // 记录f[n-2]
        int q = 1; // 记录f[n-1]
        int r = 0; // 记录f[n]
        for (int i = 2; i <= n; i++) {
            // 计算r
            r = p + q;
            // 滚动更新p、q
            p = q;
            q = r;
        }

        // 返回结果
        return r;
    }

}
