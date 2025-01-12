package com.noob.algorithm.leetcode.q001_100.q069;

/**
 * 🟢 069 x 的平方根
 */
public class Solution2 {

    /**
     * 思路分析：不允许使用任何内置指数函数的情况下完成
     */
    public int mySqrt(int x) {
        // 如果不用long处理，可以用除法来避开
        int res = 0;
        for (int i = 1; i <= x / i; i++) { // 将i*i<=x转变成除法校验，进而避开引入long
            res = i;
        }
        return (int) res;
    }
}
