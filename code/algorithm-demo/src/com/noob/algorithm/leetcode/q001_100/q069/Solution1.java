package com.noob.algorithm.leetcode.q001_100.q069;

/**
 * 🟢 069 x 的平方根
 */
public class Solution1 {

    /**
     * 思路分析：不允许使用任何内置指数函数的情况下完成
     */
    public int mySqrt(int x) {
        /*
        int res = 0;
        for (int i = 0; i * i <= x; i++) {
            res = i;
        }
        return res;
         */

        long res = 0;
        for (long i = 0; i * i <= x; i++) { // 此处用long而不是int，处理数值溢出问题
            res = i;
        }
        return (int) res;

    }
}
