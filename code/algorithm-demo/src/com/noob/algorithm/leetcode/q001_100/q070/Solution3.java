package com.noob.algorithm.leetcode.q001_100.q070;

/**
 * 🟢 70.爬楼梯 - https://leetcode.cn/problems/climbing-stairs/
 */
public class Solution3 {

    /**
     * 动态数组：空间优化
     */
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
