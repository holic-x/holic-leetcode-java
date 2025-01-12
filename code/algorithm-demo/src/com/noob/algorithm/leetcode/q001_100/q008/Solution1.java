package com.noob.algorithm.leetcode.q001_100.q008;

/**
 * 🟡 008 字符串转整数（atoi） - https://leetcode.cn/problems/string-to-integer-atoi/
 */
class Solution1 {
    public int myAtoi(String str) {
        int state = 0;
        long s = 0;
        int sign = 1;

        for (int i = 0; i < str.length(); i++) {
            // 遍历当前字符
            char t = str.charAt(i);
            // 根据字符类型设置处理状态
            if (state == 0 && t == ' ') {
                state = 0;
            } else if (state == 0 && (t == '-' || t == '+')) {
                state = 1;
            } else if ((state == 0 || state == 1 || state == 2) && (t >= '0' && t <= '9')) {
                state = 2;
            } else {
                state = 3;
            }

            // 根据状态处理结果
            if (state == 1) sign = t == '-' ? -1 : 1; // 处理符号

            if (state == 2) { // 处理数字
                s = s * 10 + (int) (t - 48);
                if (s * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE; // 超出最大阈值则直接返回
                if (s * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE; // 超出最小阈值则直接返回
            }

            // 其他符号处理（如果没有指定则跳过）
            if (state == 3) break;
        }

        // 返回最终处理的结果
        return (int) s != 0 ? (int) s * sign : 0;
    }
}