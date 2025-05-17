package com.noob.algorithm.leetcode.q501_600.q541;

/**
 * 🟢 541 反转字符串II - https://leetcode.cn/problems/reverse-string-ii/description/
 */
public class Solution1 {
    /**
     * 概要：给定字符串s和整数k，每计数至2k个字符就反转其前k个字符，如果剩余字符少于k个则反转全部剩余字符，如果剩余字符在[k,2k]则反转前k个字符
     * 思路分析：
     */
    public String reverseStr(String s, int k) {

        // 遍历字符串元素，处理反转
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i = i + 2 * k) {
            // 确定反转范围
            reverse(chs, i, Math.min(i + k, chs.length) - 1); // reverse反转范围取闭区间，需注意此处范围设定
        }

        // 返回处理后的结果
        return String.valueOf(chs);

    }

    // 定义反转方法
    private void reverse(char[] chs, int start, int end) {
        while (start < end) {
            // 交换元素
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            // 指针移动
            start++;
            end--;
        }
    }


    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        solution.reverseStr("abcdefg", 2); // res:bacdfeg

    }
}
