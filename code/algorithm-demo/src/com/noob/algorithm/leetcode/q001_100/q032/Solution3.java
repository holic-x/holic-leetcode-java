package com.noob.algorithm.leetcode.q001_100.q032;

/**
 * 🔴 032 最长有效括号 - https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class Solution3 {
    /**
     * 思路分析：计数法（双指针）
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        char[] chs = s.toCharArray();

        // 从左往右遍历(分别定义left、right计数器计算左、右括号的个数)
        int left = 0, right = 0;
        for (int i = 0; i < chs.length; i++) {
            // 更新左、右括号计数
            if (chs[i] == '(') {
                left++;
            } else if (chs[i] == ')') {
                right++;
            }
            // 校验计数
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (right > left) {
                left = right = 0; // 重置计数器
            }
        }

        // 从右往左遍历(分别定义left、right计数器计算左、右括号的个数，复用上面的计数器（先进行重置）)
        left = right = 0; // 重置计数器
        for (int i = chs.length - 1; i >= 0; i--) {
            // 更新左、右括号计数
            if (chs[i] == '(') {
                left++;
            } else if (chs[i] == ')') {
                right++;
            }
            // 校验计数
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0; // 重置计数器
            }
        }

        // 返回结果
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        Solution3 solution = new Solution3();
        System.out.println(solution.longestValidParentheses(s));
    }

}
