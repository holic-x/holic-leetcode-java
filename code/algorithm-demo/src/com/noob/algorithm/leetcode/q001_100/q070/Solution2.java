package com.noob.algorithm.leetcode.q001_100.q070;

/**
 * 🟢 70.爬楼梯 - https://leetcode.cn/problems/climbing-stairs/
 */
public class Solution2 {

    // 动态数组优化
    public int climbStairs(int n) {
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
}
